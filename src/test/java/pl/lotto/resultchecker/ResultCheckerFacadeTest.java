package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.LuckyNumbersDto;
import pl.lotto.numbersgenerator.LuckyNumbersGeneratorFacade;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ResultCheckerFacadeTest {

    @Test
    public void should_return_3_as_number_of_one_user_hits() {
        // given
        NumberReceiverFacade numberReceiverFacade = mock(NumberReceiverFacade.class);
        LuckyNumbersGeneratorFacade luckyNumbersGeneratorFacade = mock(LuckyNumbersGeneratorFacade.class);
        TicketChecker ticketChecker = new TicketChecker();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(numberReceiverFacade, luckyNumbersGeneratorFacade, ticketChecker);
        given(numberReceiverFacade.userNumbersForNextDrawDate()).willReturn(examplaryAllNumbersFromUsersDto());
        given(luckyNumbersGeneratorFacade.generateLuckyNumbers(examplaryDate)).willReturn(generateExamplaryLuckyNumbers(examplaryDate));

        // when
        List<CheckedTicket> checkedTickets = resultCheckerFacade.checkResult();
        // then
        assertThat(checkedTickets.get(0).getNumbersOfHits().size()).isEqualTo(3);
    }

    @Test
    public void should_throw_exception_when_draw_date_is_not_specifed_for_ticket() {
        // given
        NumberReceiverFacade numberReceiverFacade = mock(NumberReceiverFacade.class);
        LuckyNumbersGeneratorFacade luckyNumbersGeneratorFacade = mock(LuckyNumbersGeneratorFacade.class);
        TicketChecker ticketChecker = new TicketChecker();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(numberReceiverFacade, luckyNumbersGeneratorFacade, ticketChecker);
        given(numberReceiverFacade.userNumbersForNextDrawDate()).willReturn(examplaryAllNumbersFromUsersDtoWithEmptyDate());
        given(luckyNumbersGeneratorFacade.generateLuckyNumbers(examplaryDate)).willReturn(generateExamplaryLuckyNumbers(examplaryDate));

        // when
        Throwable throwable = catchThrowable(resultCheckerFacade::checkResult);
        // then
        assertThat(throwable).isInstanceOf(DrawDateNotSpecifedForTicketException.class);
    }


    LocalDateTime examplaryDate = LocalDateTime.of(2022, 11, 11, 11, 11);
    LocalDateTime emptyDate = null;
    UUID examplaryId = UUID.fromString("123e4567-e89b-42d3-a456-556642440000");

    LuckyNumbersDto generateExamplaryLuckyNumbers(LocalDateTime localDateTime) {
        return new LuckyNumbersDto(List.of(1, 13, 21, 44, 55, 66), localDateTime);
    }

    AllNumbersFromUsersDto examplaryAllNumbersFromUsersDto() {
        return new AllNumbersFromUsersDto(List.of(new LotteryTicketDto(examplaryId, examplaryDate, List.of(1, 13, 21, 4, 5, 6))));
    }

    AllNumbersFromUsersDto examplaryAllNumbersFromUsersDtoWithEmptyDate() {
        return new AllNumbersFromUsersDto(List.of(new LotteryTicketDto(examplaryId, emptyDate, List.of(1, 13, 21, 4, 5, 6))));
    }

}

