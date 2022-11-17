package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static pl.lotto.numberreceiver.NumberReceiverResultDto.failure;
import static pl.lotto.numberreceiver.NumberReceiverResultDto.success;

public class NumberReceiverFacade {

    private static final String FAILURE_MESSAGE = "failure";
    private static final String SUCCESS_MESSAGE = "success";
    NumberInputValidator validator;
    DrawDateSelector drawDateSelector;
    LotteryIdGenerator lotteryIdGenerator;

    NumberReceiverFacade(NumberInputValidator validator, DrawDateSelector drawDateSelector, LotteryIdGenerator lotteryIdGenerator) {
        this.validator = validator;
        this.drawDateSelector = drawDateSelector;
        this.lotteryIdGenerator = lotteryIdGenerator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        ValidationResult validate = validator.validate(numbersFromUser);
        if (validate.isNotValid()) {
            return failure(validate);
        } else {
            UUID lotteryId = LotteryIdGenerator.generateLotteryId();
            LocalDateTime drawDate = drawDateSelector.specifyExactDateNextDraw();
            return success(validate, lotteryId, drawDate);
        }
    }
}
