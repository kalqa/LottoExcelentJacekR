package pl.lotto.numbersgenerator;


import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import pl.lotto.numbersgenerator.dto.LuckyNumbersDto;
import static java.util.Collections.emptyList;

@Component
public class LuckyNumbersGeneratorFacade {

    LocalDateTime drawDate;

    private final RandomNumbersGenerator generator;

    public LuckyNumbersGeneratorFacade(RandomNumbersGenerator generator) {
        this.generator = generator;
    }

    public LuckyNumbersDto generateLuckyNumbers(LocalDateTime drawDate) {
        if (!generator.randomSixNumbers().isEmpty()) {
            return new LuckyNumbersDto(generator.randomSixNumbers(), drawDate);
        }
        generator.randomSixNumbers();
        return new LuckyNumbersDto(generator.randomSixNumbers(), drawDate);
    }

    public LuckyNumbersDto retrieve(LocalDateTime drawDate){
        if (!generator.randomSixNumbers().isEmpty()) {
            return new LuckyNumbersDto(generator.randomSixNumbers(), drawDate);
        }
        return new LuckyNumbersDto(emptyList(), drawDate);
    }
}
