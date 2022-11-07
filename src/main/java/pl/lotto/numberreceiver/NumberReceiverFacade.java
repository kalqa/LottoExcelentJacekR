package pl.lotto.numberreceiver;

import java.time.*;
import java.util.List;
import java.util.UUID;

public class NumberReceiverFacade {

    private static final String FAILURE_MESSAGE = "failure";
    private static final String SUCCESS_MESSAGE = "success";
    NumberInputValidator validator = new NumberInputValidator();

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        if (validator.validate(numbersFromUser)) {
            return new NumberReceiverResultDto(FAILURE_MESSAGE, null, null);
        }
        UUID lotteryID = LotteryIDGenerator.generateLotteryID();
        LocalDateTime drawDate = DrawDateSelector.specifyExactDateNextDraw();
        return new NumberReceiverResultDto(SUCCESS_MESSAGE, lotteryID, drawDate);
    }
}
