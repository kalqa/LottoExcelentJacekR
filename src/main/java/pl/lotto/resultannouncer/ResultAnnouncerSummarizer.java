package pl.lotto.resultannouncer;

import org.springframework.stereotype.Component;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultannouncer.dto.TicketAnnouncerDto;
import pl.lotto.resultchecker.dto.CheckedTicketDto;
import pl.lotto.resultchecker.dto.TicketCheckerBeforeDrawDto;

@Component
class ResultAnnouncerSummarizer {

    public ResultAnnouncerDto summarizeUniqueTicket(CheckedTicketDto checkedTicketDto) {
        return new ResultAnnouncerDto(new TicketAnnouncerDto(checkedTicketDto.lotteryId(), checkedTicketDto.drawDate(),
                checkedTicketDto.numbersFromUser(), checkedTicketDto.numbersOfHits()), informUser(checkedTicketDto.numbersOfHits().size()));
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
