package pl.lotto.infrastructre.scheduler.numbersgenerator;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.numbersgenerator.LuckyNumbersGeneratorFacade;

@Component
public class SchedulerNumbersGenerator {

    private final LuckyNumbersGeneratorFacade luckyNumbersGeneratorFacade;

    SchedulerNumbersGenerator(LuckyNumbersGeneratorFacade luckyNumbersGeneratorFacade) {
        this.luckyNumbersGeneratorFacade = luckyNumbersGeneratorFacade;
    }

    @Scheduled(cron = "${lotto.checker.lotteryRunOccurrence}")
    public void f() {
        luckyNumbersGeneratorFacade.generateLuckyNumbers()
    }
}
