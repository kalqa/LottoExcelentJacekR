package pl.lotto.numberreceiver;

import java.time.Clock;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade createForTests(Clock clock) {
        NumberInputValidator validator = new NumberInputValidator();
        DrawDateSelector drawDateSelector = new DrawDateSelector(clock);
        LotteryIDGenerator lotteryIDGenerator = new LotteryIDGenerator();
        return new NumberReceiverFacade(validator, drawDateSelector, lotteryIDGenerator);
    }
}
