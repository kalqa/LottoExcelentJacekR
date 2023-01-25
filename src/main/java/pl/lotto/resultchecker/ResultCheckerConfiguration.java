package pl.lotto.resultchecker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ResultCheckerConfiguration {

    @Bean
    public TicketChecker ticketChecker(){
        return new TicketChecker();
    }
    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }

}
