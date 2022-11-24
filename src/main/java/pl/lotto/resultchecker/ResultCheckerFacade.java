package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numbersgenerator.LuckyNumbersGeneratorFacade;

public class ResultCheckerFacade {

    NumberReceiverFacade receiverFacade;
    LuckyNumbersGeneratorFacade generatorFacade;

    public void checkResult(){
        receiverFacade.specifyDrawDate();
        receiverFacade.userNumbers(LocalDateTime.now());
    }
}
