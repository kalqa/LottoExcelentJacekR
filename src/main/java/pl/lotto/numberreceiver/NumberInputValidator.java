package pl.lotto.numberreceiver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberInputValidator {

    private static final int MAX_NUMBERS_FROM_USER = 6;
    private static final int MIN_INPUT_NUMBER = 1;
    private static final int MAX_INPUT_NUMBER = 99;

    public boolean validate(List<Integer> numbersFromUser) {
        return (doesUserGaveLessThanSixNumbers(numbersFromUser) || doesUserGaveMoreThanSixNumbers(numbersFromUser)
                || doesUserGaveDuplicatedNumbers(numbersFromUser) || doesUserGaveNumbersInRange(numbersFromUser));
    }

    private static boolean doesUserGaveLessThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() < MAX_NUMBERS_FROM_USER;
    }

    private static boolean doesUserGaveMoreThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() > MAX_NUMBERS_FROM_USER;
    }

    private static boolean doesUserGaveDuplicatedNumbers(List<Integer> numbersFromUser) {
        Set<Integer> numberFromUserWithoutDuplicates = new HashSet<>(numbersFromUser);
        return numbersFromUser.size() != numberFromUserWithoutDuplicates.size();
    }

    private static boolean doesUserGaveNumbersInRange(List<Integer> numbersFromUser) {
        return !numbersFromUser.stream()
                .filter(number -> number < MIN_INPUT_NUMBER || number > MAX_INPUT_NUMBER)
                .collect(Collectors.toList())
                .isEmpty();
    }

}
