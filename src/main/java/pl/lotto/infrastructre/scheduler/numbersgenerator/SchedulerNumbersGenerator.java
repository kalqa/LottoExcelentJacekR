package pl.lotto.infrastructre.scheduler.numbersgenerator;


import java.time.LocalDateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numbersgenerator.LuckyNumbersGeneratorFacade;

@Component
public class SchedulerNumbersGenerator {

    private final LuckyNumbersGeneratorFacade luckyNumbersGeneratorFacade;
    private final NumberReceiverFacade numberReceiverFacade;

    SchedulerNumbersGenerator(LuckyNumbersGeneratorFacade luckyNumbersGeneratorFacade, NumberReceiverFacade numberReceiverFacade) {
        this.luckyNumbersGeneratorFacade = luckyNumbersGeneratorFacade;
        this.numberReceiverFacade = numberReceiverFacade;
    }

    @Scheduled(cron = "${lotto.checker.lotteryRunOccurrence}")
    public void f() {
        System.out.println(LocalDateTime.now());
        LocalDateTime drawDate = numberReceiverFacade.specifyDrawDate().drawDate();
        luckyNumbersGeneratorFacade.generateLuckyNumbers(drawDate);
    }
}
