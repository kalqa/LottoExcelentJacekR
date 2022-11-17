package pl.lotto.numberreceiver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.lotto.numberreceiver.ValidationError.*;

public class NumberInputValidator {

    private static final int MAX_NUMBERS_FROM_USER = 6;
    private static final int MIN_INPUT_NUMBER = 1;
    private static final int MAX_INPUT_NUMBER = 99;

    List<ValidationError> errors = new LinkedList<>();

    public ValidationResult validate(List<Integer> numbersFromUser) {
        if (doesUserGaveDuplicatedNumbers(numbersFromUser)) {
            errors.add(DUPLICATED_NUMBERS);
        }
        if (doesUserGaveLessThanSixNumbers(numbersFromUser)) {
            errors.add(LESS_THAN_SIX_NUMBER);
        }
        if (doesUserGaveMoreThanSixNumbers(numbersFromUser)) {
            errors.add(MORE_THAN_SIX_NUMBER);
        }
        if (doesUserGaveNumbersInRange(numbersFromUser)) {
            errors.add(NUMBERS_IN_RANGE);
        }
        if (!errors.isEmpty()) {
            String message = concatenateValidationMessage();
            return new ValidationResult("failure");
        }
        return new ValidationResult("success");
    }

    private String concatenateValidationMessage() {
        return errors.stream()
                .map(error -> error.message)
                .collect(Collectors.joining(","));
    }

    private boolean doesUserGaveLessThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() < MAX_NUMBERS_FROM_USER;
    }

    private boolean doesUserGaveMoreThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() > MAX_NUMBERS_FROM_USER;
    }

    private boolean doesUserGaveDuplicatedNumbers(List<Integer> numbersFromUser) {
        Set<Integer> numberFromUserWithoutDuplicates = new HashSet<>(numbersFromUser);
        return numbersFromUser.size() != numberFromUserWithoutDuplicates.size();
    }

    private boolean doesUserGaveNumbersInRange(List<Integer> numbersFromUser) {
        return numbersFromUser.stream().anyMatch(number -> number < MIN_INPUT_NUMBER || number > MAX_INPUT_NUMBER);
    }

}
