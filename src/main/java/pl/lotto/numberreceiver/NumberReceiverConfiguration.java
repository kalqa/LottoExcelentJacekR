package pl.lotto.numberreceiver;

import java.time.Clock;
import java.util.List;

public class NumberReceiverConfiguration {
    DrawDateSelector drawDateSelector;
    NumberInputValidator validator;
    LotteryIdGenerator lotteryIdGenerator;

    public NumberReceiverConfiguration(Clock clock) {
        drawDateSelector = new DrawDateSelector(clock);
        validator = new NumberInputValidator();
        lotteryIdGenerator = new LotteryIdGenerator();
    }

    public NumberReceiverFacade createForTests() {
        return new NumberReceiverFacade(validator, drawDateSelector, lotteryIdGenerator);
    }
}
