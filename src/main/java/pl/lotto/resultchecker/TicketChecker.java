package pl.lotto.resultchecker;

import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.LuckyNumbersGeneratorResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketChecker {
    private List<Integer> numbersOfHits;
    List<LotteryTicketDto> ticketsFromUsers;

    List<CheckedTicket> checkAllTickets(List<LuckyNumbersGeneratorResultDto> luckyNumbers, List<LotteryTicketDto> ticketsFromUsers) {
        this.ticketsFromUsers = ticketsFromUsers;

        List<CheckedTicket> checkedTickets = new ArrayList<>();
        for (LotteryTicketDto ticket : ticketsFromUsers ) {
                checkedTickets.add(new CheckedTicket(ticket.lotteryId(), ticket.drawDate(), ticket.numbersFromUser(), numbersOfHits));

            List<CheckedTicket> ticketsWithMatchingDrawDate = checkedTickets.stream()
                    .filter(e -> luckyNumbers.stream()
                            .map(LuckyNumbersGeneratorResultDto::drawDate)
                            .anyMatch(name -> name.equals(e.getDrawDate()))).toList();

            for (Integer numberOfHits : numbersOfHits ) {
            List<CheckedTicket> ticketsWithMatchingDrawDateAndNumbers = checkedTickets.stream()
                    .filter(e -> luckyNumbers.stream()
                            .map(LuckyNumbersGeneratorResultDto::numbers)
                            .anyMatch(name -> name.equals(e.getNumbersFromUser())) ).toList();





        }
    }
}
