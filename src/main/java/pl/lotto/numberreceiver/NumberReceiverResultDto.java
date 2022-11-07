package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.UUID;

public record NumberReceiverResultDto(
        String message,
        UUID lotteryId,
        LocalDateTime drawDate
) {
}
