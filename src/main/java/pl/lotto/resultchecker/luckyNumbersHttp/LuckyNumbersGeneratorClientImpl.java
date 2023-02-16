package pl.lotto.resultchecker.luckyNumbersHttp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LuckyNumbersGeneratorClientImpl implements LuckyNumbersGeneratorClient {

    private final RestTemplate restTemplate;

    @Value("${luckyNumbersGeneratorFacade.url:http://localhost}")
    private String luckyNumbersGeneratorFacadeUrl;

    @Value("${luckyNumbersGeneratorFacade.port:8087}")
    private String luckyNumbersGeneratorFacadePort;

    public LuckyNumbersGeneratorClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LuckyNumbersDto retrieveLuckyNumbersForDate(LocalDateTime date) {
        String url = luckyNumbersGeneratorFacadeUrl + ":" + luckyNumbersGeneratorFacadePort + "/?" + "date="
                + date.format(DateTimeFormatter.ISO_DATE_TIME);

        ResponseEntity<LuckyNumbersDto> response = restTemplate.getForEntity(url, LuckyNumbersDto.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new IllegalStateException("Unexpected status code: " + response.getStatusCodeValue());
        }
    }
}
