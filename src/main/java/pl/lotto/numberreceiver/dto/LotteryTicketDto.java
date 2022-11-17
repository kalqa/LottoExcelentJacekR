package pl.lotto.numberreceiver.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record LotteryTicketDto(
        UUID lotteryId,
        LocalDateTime drawDate,
        List<Integer> numbersFromUser
) {
}
