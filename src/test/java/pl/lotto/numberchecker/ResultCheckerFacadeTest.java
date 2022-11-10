package pl.lotto.numberchecker;

import org.junit.jupiter.api.Test;
import pl.lotto.resultchecker.ResultCheckerFacade;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultCheckerFacadeTest {

    @Test
    public void should_return_success_when_user_gave_six_numbers_in_range() {
        // given
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when

        // then

    }
}
