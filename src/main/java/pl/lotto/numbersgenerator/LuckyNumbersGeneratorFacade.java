package pl.lotto.numbersgenerator;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import org.springframework.stereotype.Component;
import pl.lotto.numbersgenerator.dto.LuckyNumbersDto;
import static java.util.Collections.emptyList;

@Component
public class LuckyNumbersGeneratorFacade {

    private static final int lotterySize = 6;
    private static final int startOfNumbersRange = 1;
    private static final int endOfNumbersRange = 99;

    private final RandomNumbersGenerator generator;
    private final Random random;

    LuckyNumbersGeneratorFacade(Random random) {
        this.random = random;
    }

    Collection<Integer> luckyNumbers = new HashSet<>();

    public LuckyNumbersDto generateLuckyNumbers(LocalDateTime drawDate) {
        if (!luckyNumbers.isEmpty()) {
            return new LuckyNumbersDto(luckyNumbers, drawDate);
        }
        while (luckyNumbers.size() < lotterySize) {
            int e = random.nextInt(startOfNumbersRange, endOfNumbersRange + 1);
            luckyNumbers.add(e);
        }
        return new LuckyNumbersDto(luckyNumbers, drawDate);
    }

    public LuckyNumbersDto retrieve(LocalDateTime drawDate) {
        if (!luckyNumbers.isEmpty()) {
            return new LuckyNumbersDto(luckyNumbers, drawDate);
        }
        return new LuckyNumbersDto(emptyList(), drawDate);
    }
}
