package pl.lotto.resultchecker;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;

public class TicketChecker {
    private List<Integer> numbersOfHits;
    List<LotteryTicketDto> ticketsFromUsers;

//    List<CheckedTicket> checkAllTickets(Collection<Integer> luckyNumbers, List<LotteryTicketDto> ticketsFromUsers) {
//        this.ticketsFromUsers = ticketsFromUsers;
//
//        List<CheckedTicket> checkedTickets = new ArrayList<>();
//        for (LotteryTicketDto ticket : ticketsFromUsers ) {
//                checkedTickets.add(new CheckedTicket(ticket.lotteryId(), ticket.drawDate(), ticket.numbersFromUser(), numbersOfHits));
//
//            List<CheckedTicket> ticketsWithMatchingDrawDate = checkedTickets.stream()
//                    .filter(e -> luckyNumbers.stream()
//                            .map(LuckyNumbersGeneratorResultDto::drawDate)
//                            .anyMatch(name -> name.equals(e.getDrawDate()))).toList();
//
//            for (Integer numberOfHits : numbersOfHits ) {
//            List<CheckedTicket> ticketsWithMatchingDrawDateAndNumbers = checkedTickets.stream()
//                    .filter(e -> luckyNumbers.stream()
//                            .map(LuckyNumbersGeneratorResultDto::numbers)
//                            .anyMatch(name -> name.equals(e.getNumbersFromUser())) ).toList();
//        }
//    }

    List<CheckedTicket> checkAllTickets(Collection<Integer> luckyNumbers, List<LotteryTicketDto> ticketsFromUsers) {
        return ticketsFromUsers
                .stream()
                .map(lotteryTicketDto -> fromDto(luckyNumbers, lotteryTicketDto))
                .collect(Collectors.toList());

    }

    private CheckedTicket fromDto(Collection<Integer> luckyNumbers, LotteryTicketDto ticket) {
        return new CheckedTicket(ticket.lotteryId(), ticket.drawDate(), ticket.numbersFromUser(), calculateNumbersOfHit(ticket.numbersFromUser(), luckyNumbers));
    }

    private Set<Integer> calculateNumbersOfHit(List<Integer> numbersFromUser, Collection<Integer> luckyNumbers) {
        return numbersFromUser.stream()
                .distinct()
                .filter(luckyNumbers::contains)
                .collect(Collectors.toSet());
    }
}
