package pl.lotto.resultchecker.luckyNumbersHttp;

import java.time.LocalDateTime;

public interface LuckyNumbersGeneratorClient {
    LuckyNumbersDto retrieveLuckyNumbersForDate(LocalDateTime date);
}
