package pl.lotto.infrastructre.controller.numberreceiver;

import java.util.List;

public class InputNumbersRequest {

    List<Integer> numbers;

    InputNumbersRequest() {
    }

    InputNumbersRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
