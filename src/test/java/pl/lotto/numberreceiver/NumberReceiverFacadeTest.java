package pl.lotto.numberreceiver;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeTest {

    @Test
    public void should_return_success_when_user_gave_six_numbers_in_range() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("success");
    }

    @Test
    public void should_return_failure_when_user_gave_less_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("failure");
    }

    @Test
    public void should_return_success_with_lottery_unique_id_when_user_gave_correct_input() {
    }

    @Test
    public void should_return_success_with_correct_draw_date_id_when_user_played_on_friday() {
    }

    @Test
    public void should_return_failure_when_user_gave_more_than_six_numbers() {
    }

    @Test
    public void should_return_failure_when_user_gave_duplicated_numbers() {
    }

    @Test
    public void should_return_failure_when_user_gave_numbers_out_of_range() {
    }
}
