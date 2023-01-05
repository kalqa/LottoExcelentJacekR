package pl.lotto.numbersgenerator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import pl.lotto.numbersgenerator.dto.LuckyNumbersDto;

import static java.util.Collections.emptyList;

//@Component
public class LuckyNumbersGeneratorFacade {

    LocalDateTime drawDate;

    private RandomNumbersGenerator generator;

    @Autowired
    public LuckyNumbersGeneratorFacade(RandomNumbersGenerator generator) {
        this.generator = generator;
    }

    public LuckyNumbersDto generateLuckyNumbers(LocalDateTime drawDate) {
        if (!generator.luckyNumbers.isEmpty()) {
            return new LuckyNumbersDto(generator.luckyNumbers, drawDate);
        }
        generator.randomSixNumbers();
        return new LuckyNumbersDto(generator.luckyNumbers, drawDate);
    }

    public LuckyNumbersDto retrieve(LocalDateTime drawDate) {
        if (!generator.luckyNumbers.isEmpty()) {
            return new LuckyNumbersDto(generator.luckyNumbers, drawDate);
        }
        return new LuckyNumbersDto(emptyList(), drawDate);
    }
}
