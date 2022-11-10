package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import static pl.lotto.numberreceiver.NumberReceiverResultDto.failure;
import static pl.lotto.numberreceiver.NumberReceiverResultDto.success;

public class NumberReceiverFacade {

    private static final String SUCCESS_MESSAGE = "success";
    NumberInputValidator validator = new NumberInputValidator();

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        ValidationResult validate = validator.validate(numbersFromUser);
        if (validate.isNotValid()) {
            return failure(validate);
        }
        UUID lotteryID = LotteryIdGenerator.generateLotteryID();
        LocalDateTime drawDate = DrawDateSelector.specifyExactDateNextDraw();
        return success(validate, lotteryID, drawDate);
    }
}
