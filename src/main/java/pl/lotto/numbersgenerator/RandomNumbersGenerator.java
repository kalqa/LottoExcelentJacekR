package pl.lotto.numbersgenerator;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class RandomNumbersGenerator implements SixNumberGenerable {

    private static final int lotterySize = 6;
    private static final int startOfNumbersRange = 1;
    private static final int endOfNumbersRange = 99;
    Set<Integer> luckyNumbers = new HashSet<>();
    Random random = new Random();

    @Override
    public Set<Integer> randomSixNumbers() {

        while (luckyNumbers.size() < lotterySize) {

            int e = random.nextInt(startOfNumbersRange, endOfNumbersRange + 1);
            luckyNumbers.add(e);
        }
        return luckyNumbers;
    }

    public RandomNumbersGenerator() {
    }
}

