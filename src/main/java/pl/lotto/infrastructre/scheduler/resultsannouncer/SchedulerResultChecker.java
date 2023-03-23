package pl.lotto.infrastructre.scheduler.resultsannouncer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.resultchecker.ResultCheckerFacade;

import java.time.LocalDateTime;

@Component
public class SchedulerResultChecker {

    private final ResultCheckerFacade resultCheckerFacade;


    public SchedulerResultChecker(ResultCheckerFacade resultCheckerFacade) {
        this.resultCheckerFacade = resultCheckerFacade;
    }

//    @Scheduled(cron = "${lotto.checker.lotteryResultsAnnouncement}")
//    public void f() {
//        System.out.println(LocalDateTime.now());
//        resultCheckerFacade.checkResult();
//    }
}

