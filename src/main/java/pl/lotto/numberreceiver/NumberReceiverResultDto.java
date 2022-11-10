package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.UUID;

public record NumberReceiverResultDto(
        String message,
        UUID lotteryId,
        LocalDateTime drawDate
) {

    public static NumberReceiverResultDto failure(ValidationResult result) {
        return new NumberReceiverResultDto(result.message(), null, null);
    }

    public static NumberReceiverResultDto success(ValidationResult result, UUID lotteryID, LocalDateTime drawDate) {
        return new NumberReceiverResultDto(result.message(), lotteryID, drawDate);
    }
}
