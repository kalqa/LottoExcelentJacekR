package pl.lotto.numberreceiver;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumberReceiverConfiguration {

//    Clock clock;

//    public NumberReceiverConfiguration(Clock clock) {
//        this.clock = clock;
//    }

    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public NumberReceiverFacade numberReceiverFacade(NumberReceiverRepository repository, Clock clock) {
        DrawDateSelector drawDateSelector = new DrawDateSelector(clock);
        NumberInputValidator validator = new NumberInputValidator();
        LotteryIdGenerator lotteryIdGenerator = new LotteryIdGenerator();
        return new NumberReceiverFacade(validator, drawDateSelector, lotteryIdGenerator, repository);
    }

    public NumberReceiverFacade createForTests(NumberReceiverRepository repository) {
        return numberReceiverFacade(repository, Clock.systemUTC());
    }
}
