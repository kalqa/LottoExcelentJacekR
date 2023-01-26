package pl.lotto;

import pl.lotto.numbersgenerator.RandomNumbersGenerator;

import java.util.HashSet;
import java.util.Set;

public class AdjustableNumberGenerator extends RandomNumbersGenerator {

    Set<Integer> luckyNumbers = new HashSet<>();
    @Override
    public Set<Integer> randomSixNumbers() {
        luckyNumbers = Set.of(1,2,3,4,5,6);
        return luckyNumbers;
    }
}
