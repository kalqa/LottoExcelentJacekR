package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NumberReceiverFacade {

    private static final String FAILURE_MESSAGE = "failure";
    private static final String SUCCESS_MESSAGE = "success";
    NumberInputValidator validator;
    DrawDateSelector drawDateSelector;
    LotteryIDGenerator lotteryIDGenerator;

    NumberReceiverFacade(NumberInputValidator validator, DrawDateSelector drawDateSelector, LotteryIDGenerator lotteryIDGenerator) {
        this.validator = validator;
        this.drawDateSelector = drawDateSelector;
        this.lotteryIDGenerator = lotteryIDGenerator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        if (validator.validate(numbersFromUser)) {
            return new NumberReceiverResultDto(FAILURE_MESSAGE, null, null);
        }
        UUID lotteryID = lotteryIDGenerator.generateLotteryID();
        LocalDateTime drawDate = drawDateSelector.specifyExactDateNextDraw();
        return new NumberReceiverResultDto(SUCCESS_MESSAGE, lotteryID, drawDate);
    }
}
