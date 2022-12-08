package pl.lotto.resultannouncer.dto;

import pl.lotto.resultannouncer.AnnouncerMessages;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record ResultAnnouncerDto(UUID ticketId, LocalDateTime drawDate,
                                 List<Integer> userNumbers, Set<Integer> numbersOfHit, AnnouncerMessages message) {
}
