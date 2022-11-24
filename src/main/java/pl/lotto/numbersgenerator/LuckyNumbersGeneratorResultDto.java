package pl.lotto.numbersgenerator;

import java.time.LocalDateTime;
import java.util.List;

public record LuckyNumbersGeneratorResultDto(LocalDateTime drawDate, List<Integer> numbers) {

}
