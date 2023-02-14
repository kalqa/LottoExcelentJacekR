package pl.lotto.resultchecker.luckyNumbersHttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LuckyNumbersGeneratorClientImpl implements LuckyNumbersGeneratorClient {

    private final RestTemplate restTemplate;

    @Value("${luckyNumbersGeneratorFacade.url:localhost}")
    private String luckyNumbersGeneratorFacadeUrl;

    @Value("${luckyNumbersGeneratorFacade.port:8087}")
    private String luckyNumbersGeneratorFacadePort;

    public LuckyNumbersGeneratorClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LuckyNumbersDto retrieveLuckyNumbersForDate(LocalDateTime date) {
        String url = "http://" + luckyNumbersGeneratorFacadeUrl + ":" +luckyNumbersGeneratorFacadePort + "/?" + "date="
                + date.format(DateTimeFormatter.ISO_DATE_TIME);

        System.out.println("***************** url jaki idzie: " + url +" +++++++++++++++++++++");
        return restTemplate.getForObject(url, LuckyNumbersDto.class);
    }

    @Override
    public LuckyNumbersDto generateLuckyNumbers(LocalDateTime drawDate) {
        return null;
    }
}
