package pl.lotto.resultannouncer.dto;

import pl.lotto.resultannouncer.AnnouncerMessages;

public record ResultAnnouncerDto(TicketAnnounceDto ticketAnnounce,
                                 AnnouncerMessages message) {
}
