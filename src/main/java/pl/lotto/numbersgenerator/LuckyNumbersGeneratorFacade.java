package pl.lotto.numbersgenerator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class LuckyNumbersGeneratorFacade {

    private static final int lotterySize = 6;
    private static final int startOfNumbersRange = 1;
    private static final int endOfNumbersRange = 99;

    Random random = new Random();

    Collection<Integer> luckyNumbers = new HashSet<>();

    public LuckyNumbersDto generateLuckyNumbers() {
        while (luckyNumbers.size() < lotterySize) {
            luckyNumbers.add(random.nextInt(startOfNumbersRange, endOfNumbersRange + 1));
        }
        return new LuckyNumbersDto(luckyNumbers);
    }
}
