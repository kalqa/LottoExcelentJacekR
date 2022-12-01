package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;

import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.LuckyNumbersDto;
import pl.lotto.numbersgenerator.LuckyNumbersGeneratorFacade;

public class ResultCheckerFacade {

    NumberReceiverFacade receiverFacade;
    LuckyNumbersGeneratorFacade generatorFacade;
    TicketChecker ticketChecker;

    public ResultCheckerFacade(NumberReceiverFacade receiverFacade, LuckyNumbersGeneratorFacade generatorFacade, TicketChecker ticketChecker) {
        this.receiverFacade = receiverFacade;
        this.generatorFacade = generatorFacade;
        this.ticketChecker = ticketChecker;
    }

    public List<CheckedTicket> checkResult() {
        AllNumbersFromUsersDto allNumbersFromUsersDto = receiverFacade.userNumbersForNextDrawDate();
        LocalDateTime drawDate = allNumbersFromUsersDto.tickets()
                .stream()
                .findFirst()
                .map(LotteryTicketDto::drawDate)
                .orElseThrow(DrawDateNotSpecifedForTicketException::new);

        LuckyNumbersDto luckyNumbersDto = generatorFacade.generateLuckyNumbers(drawDate);

        List<CheckedTicket> checkedTickets = ticketChecker.checkAllTickets(luckyNumbersDto.winningNumbers(), allNumbersFromUsersDto.tickets());
        //        repository.saveAll(checkedTickets);
        return checkedTickets;

    }
}
