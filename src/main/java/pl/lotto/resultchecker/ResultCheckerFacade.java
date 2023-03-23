package pl.lotto.resultchecker;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.DrawDateDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.resultannouncer.UniqueTicketResultDto;
import pl.lotto.resultchecker.dto.CheckedTicketDto;
import pl.lotto.resultchecker.dto.TicketStateDto;
import pl.lotto.resultchecker.luckyNumbersHttp.LuckyNumbersDto;
import pl.lotto.resultchecker.luckyNumbersHttp.LuckyNumbersGeneratorClient;


@Component
public class ResultCheckerFacade {
    NumberReceiverFacade receiverFacade;
    LuckyNumbersGeneratorClient generatorClient;
    TicketChecker ticketChecker;
    @Autowired
    Clock clock;
    ResultCheckerRepository repository;

    @Autowired
    public ResultCheckerFacade(NumberReceiverFacade receiverFacade,
                               LuckyNumbersGeneratorClient generatorClient,
                               TicketChecker ticketChecker,
                               ResultCheckerRepository repository) {
        this.receiverFacade = receiverFacade;
        this.generatorClient = generatorClient;
        this.ticketChecker = ticketChecker;
        this.repository = repository;
    }

    public boolean wasCheckedForNextDrawDate() {
        DrawDateDto drawDateDto = receiverFacade.specifyDrawDate();
        return repository.existsByDrawDate(drawDateDto.drawDate());
    }

    public List<CheckedTicket> generateResult() {
        AllNumbersFromUsersDto allNumbersFromUsersDto = receiverFacade.userNumbersForNextDrawDate();
        if (!allNumbersFromUsersDto.tickets().isEmpty()) {
            LocalDateTime drawDate = allNumbersFromUsersDto.tickets()
                    .stream()
                    .findFirst()
                    .map(LotteryTicketDto::drawDate)
                    .orElseThrow(DrawDateNotSpecifiedForTicketException::new);
            LuckyNumbersDto luckyNumbersDto = generatorClient.retrieveLuckyNumbersForDate(drawDate);
            List<CheckedTicket> checkedTickets = ticketChecker.checkAllTickets(luckyNumbersDto.winningNumbers(),
                    allNumbersFromUsersDto.tickets());
            repository.saveAll(checkedTickets);
            return checkedTickets;
        }
//        throw new IllegalArgumentException("No users numbers found")
//        Counter counter = new Counter();
//        LuckyNumbersDto luckyNumbersDto = generatorClient.retrieveLuckyNumbersForDate(LocalDateTime.parse("2022-02-08T12:00:00").plusDays(Counter.counter));
//        counter.counterIncrease();
//        System.out.println("++++++++   Przeslane od LuckyNumbersGenerator liczby: " + luckyNumbersDto + "   ++++++++");
        return List.of(new CheckedTicket(null, null, null, null));
    }

    public UniqueTicketResultDto checkUniqueTicket(UUID id) {
        Optional<CheckedTicket> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return new UniqueTicketResultDto(null, TicketStateDto.NOT_FOUND);
        }
        CheckedTicket checkedTicket = byId.get();
        boolean after = checkedTicket.getDrawDate().isAfter(LocalDateTime.now(clock));
        if (after) {
            return new UniqueTicketResultDto(null, TicketStateDto.TOO_EARLY);
        }
        return new UniqueTicketResultDto(new CheckedTicketDto(checkedTicket.getLotteryId(), checkedTicket.getDrawDate(),
                checkedTicket.getNumbersFromUser(), checkedTicket.getNumbersOfHits()), TicketStateDto.CHECKED);
    }
}
