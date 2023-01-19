package pl.lotto.resultannouncer.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record TicketAnnouncerDto(UUID ticketId,
                                 LocalDateTime drawDate,
                                 List<Integer> userNumbers,
                                 Set<Integer> numbersOfHit) {

}
