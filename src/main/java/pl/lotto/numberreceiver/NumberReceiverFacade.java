package pl.lotto.numberreceiver;

import java.util.List;

public class NumberReceiverFacade {

    public static final int MAX_NUMBERS_FROM_USER = 6;
    public static final String FAILURE_MESSAGE = "failure";
    public static final String SUCCESS_MESSAGE = "success";

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        if (doesUserGaveLessThanSixNumbers(numbersFromUser)) {
            return new NumberReceiverResultDto(FAILURE_MESSAGE);
        }
        return new NumberReceiverResultDto(SUCCESS_MESSAGE);
    }

    private static boolean doesUserGaveLessThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() < MAX_NUMBERS_FROM_USER;
    }
}
