package pl.lotto.resultannouncer.dto;

import pl.lotto.resultannouncer.AnnouncerMessages;

public record ResultAnnouncerDto(TicketAnnouncerDto ticketAnnounce,
                                 AnnouncerMessages message) {
}
