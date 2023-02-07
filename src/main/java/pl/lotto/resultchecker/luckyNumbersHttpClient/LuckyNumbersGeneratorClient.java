package pl.lotto.resultchecker.luckyNumbersHttpClient;

import java.time.LocalDateTime;

public interface LuckyNumbersGeneratorClient {
    LuckyNumbersDto retrieveLuckyNumbersForDate(LocalDateTime date);
    LuckyNumbersDto generateLuckyNumbers(LocalDateTime drawDate);
}
