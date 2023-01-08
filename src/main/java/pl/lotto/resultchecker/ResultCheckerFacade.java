package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.dto.LuckyNumbersDto;
import pl.lotto.numbersgenerator.LuckyNumbersGeneratorFacade;

@Component
public class ResultCheckerFacade {

    NumberReceiverFacade receiverFacade;
    LuckyNumbersGeneratorFacade generatorFacade;
    TicketChecker ticketChecker;
    ResultCheckerRepository repository;

    @Autowired
    public ResultCheckerFacade(NumberReceiverFacade receiverFacade, LuckyNumbersGeneratorFacade generatorFacade, TicketChecker ticketChecker, ResultCheckerRepository repository) {
        this.receiverFacade = receiverFacade;
        this.generatorFacade = generatorFacade;
        this.ticketChecker = ticketChecker;
        this.repository = repository;
    }

    public List<CheckedTicket> checkResult() {
        AllNumbersFromUsersDto allNumbersFromUsersDto = receiverFacade.userNumbersForNextDrawDate();
        LocalDateTime drawDate = allNumbersFromUsersDto.tickets()
                .stream()
                .findFirst()
                .map(LotteryTicketDto::drawDate)
                .orElseThrow(DrawDateNotSpecifedForTicketException::new);

        LuckyNumbersDto luckyNumbersDto = generatorFacade.retrieve(drawDate);

        List<CheckedTicket> checkedTickets = ticketChecker.checkAllTickets(luckyNumbersDto.winningNumbers(), allNumbersFromUsersDto.tickets());
        repository.saveAll(checkedTickets);
        return checkedTickets;
    }

//    public List<CheckedTicket> checkWinningsInExactDate(LocalDateTime date) {
//        return repository.findAllByDate(date);
//    }

    public Optional<CheckedTicket> checkUniqueTicket(UUID id) {
        return repository.findById(id);
    }
}
