package pl.lotto;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("integration")
public class IntegrationTestConfiguration {

    @Bean
    @Primary
    Clock clock() {
        LocalDateTime friday = LocalDateTime.of(2022, 11, 19, 11, 0, 0);
        return new AdjustableClock(friday.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
    }
}
