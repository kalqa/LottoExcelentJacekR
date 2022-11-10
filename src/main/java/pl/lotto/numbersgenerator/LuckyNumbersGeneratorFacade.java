package pl.lotto.numbersgenerator;

import java.util.Collection;
import java.util.HashSet;

public class LuckyNumbersGeneratorFacade {

    private static final int lotterySize =  6;
    private static final int numbersRange =  99;

    Collection<Integer> luckyNumbers = new HashSet<>();

    public LuckyNumbersDto generateLuckyNumbers() {
        while (luckyNumbers.size() < lotterySize) {
            luckyNumbers.add((int) (Math.floor(Math.random() * numbersRange) + 1));
        }
        return new LuckyNumbersDto(luckyNumbers);
    }
}
