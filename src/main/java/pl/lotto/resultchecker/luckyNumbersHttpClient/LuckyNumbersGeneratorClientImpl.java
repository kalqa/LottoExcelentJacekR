package pl.lotto.resultchecker.luckyNumbersHttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LuckyNumbersGeneratorClientImpl implements LuckyNumbersGeneratorClient {

    private final RestTemplate restTemplate;

    @Value("${luckyNumbersGeneratorFacade.url}")
    private String luckyNumbersGeneratorFacadeUrl;

    public LuckyNumbersGeneratorClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LuckyNumbersDto retrieveLuckyNumbersForDate(LocalDateTime date) {
        String url = luckyNumbersGeneratorFacadeUrl + "/" + date.format(DateTimeFormatter.ISO_DATE_TIME);
        return restTemplate.getForObject(url, LuckyNumbersDto.class);
    }

    @Override
    public LuckyNumbersDto generateLuckyNumbers(LocalDateTime drawDate) {
        return null;
    }
}
