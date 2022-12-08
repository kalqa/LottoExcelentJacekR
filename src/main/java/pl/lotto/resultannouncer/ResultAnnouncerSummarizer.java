package pl.lotto.resultannouncer;

import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.CheckedTicket;

public class ResultAnnouncerSummarizer {
    ResultAnnouncerDto summarizedTicket;

    public ResultAnnouncerDto summarizeUniqueTicket(CheckedTicket checkedTicket) {
        summarizedTicket = new ResultAnnouncerDto(checkedTicket.getLotteryId(), checkedTicket.getDrawDate(),
                checkedTicket.getNumbersFromUser(), checkedTicket.getNumbersOfHits(), informUser(checkedTicket.getNumbersOfHits().size()));
        return summarizedTicket;
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
