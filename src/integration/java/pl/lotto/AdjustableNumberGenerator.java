package pl.lotto;

import pl.lotto.numbersgenerator.RandomNumbersGenerator;

import java.util.Set;

public class AdjustableNumberGenerator extends RandomNumbersGenerator {

    @Override
    public Set<Integer> randomSixNumbers() {
        luckyNumbers.add(1);
        luckyNumbers.add(2);
        luckyNumbers.add(3);
        luckyNumbers.add(4);
        luckyNumbers.add(5);
        luckyNumbers.add(6);
        return luckyNumbers;
    }
}
