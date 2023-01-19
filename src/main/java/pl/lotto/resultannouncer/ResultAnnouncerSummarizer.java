package pl.lotto.resultannouncer;

import org.springframework.stereotype.Component;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultannouncer.dto.TicketAnnouncerDto;
import pl.lotto.resultchecker.CheckedTicket;

import java.util.Optional;

@Component
class ResultAnnouncerSummarizer {

    public ResultAnnouncerDto summarizeUniqueTicket(Optional<CheckedTicket> checkedTicket) {
        return new ResultAnnouncerDto(new TicketAnnouncerDto(checkedTicket.get().getLotteryId(), checkedTicket.get().getDrawDate(),
                checkedTicket.get().getNumbersFromUser(), checkedTicket.get().getNumbersOfHits()), informUser(checkedTicket.get().getNumbersOfHits().size()));
    }

    private AnnouncerMessages informUser(int numberOfHit) {
        return switch (numberOfHit) {
            case 6 -> AnnouncerMessages.MAIN_PRIZE;
            case 5 -> AnnouncerMessages.SECOND_PRIZE;
            case 4 -> AnnouncerMessages.THIRD_PRIZE;
            case 3 -> AnnouncerMessages.FOURTH_PRIZE;
            default -> AnnouncerMessages.NO_PRIZE;
        };
    }
}
