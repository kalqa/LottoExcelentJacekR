package pl.lotto.resultannouncer;

import org.junit.jupiter.api.Test;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.CheckedTicket;
import pl.lotto.resultchecker.ResultCheckerFacade;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ResultAnnouncerFacadeTest {


    @Test
    public void should_return_info_that_user_won_main_prize() {
        //given
        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3, 4, 5, 6);
        CheckedTicket checkedTicket = mock(CheckedTicket.class);
        given(checkedTicket.getLotteryId()).willReturn(exemplaryId);
        given(checkedTicket.getNumbersOfHits()).willReturn(exemplaryNumbersOfHits);
        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(checkedTicket);
        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository);
        //when
        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
        //then
        assertThat(verifiedTicket.message().message).isEqualTo("You won the main prize!");
    }

    @Test
    public void should_return_info_that_user_won_second_prize() {
        //given
        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3, 4, 5);
        CheckedTicket checkedTicket = mock(CheckedTicket.class);
        given(checkedTicket.getLotteryId()).willReturn(exemplaryId);
        given(checkedTicket.getNumbersOfHits()).willReturn(exemplaryNumbersOfHits);
        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(checkedTicket);
        given(resultCheckerFacade.checkResult()).willReturn(List.of(checkedTicket));
        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository);
        //when
        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
        //then
        assertThat(verifiedTicket.message().message).isEqualTo("You have won the second prize!");
    }

    @Test
    public void should_return_info_that_user_won_third_prize() {
        //given
        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3, 4);
        CheckedTicket checkedTicket = mock(CheckedTicket.class);
        given(checkedTicket.getLotteryId()).willReturn(exemplaryId);
        given(checkedTicket.getNumbersOfHits()).willReturn(exemplaryNumbersOfHits);
        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(checkedTicket);
        given(resultCheckerFacade.checkResult()).willReturn(List.of(checkedTicket));
        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository);
        //when
        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
        //then
        assertThat(verifiedTicket.message().message).isEqualTo("You have won the third prize!");
    }

    @Test
    public void should_return_info_that_user_won_fourth_prize() {
        //given
        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3);
        CheckedTicket checkedTicket = mock(CheckedTicket.class);
        given(checkedTicket.getLotteryId()).willReturn(exemplaryId);
        given(checkedTicket.getNumbersOfHits()).willReturn(exemplaryNumbersOfHits);
        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(checkedTicket);
        given(resultCheckerFacade.checkResult()).willReturn(List.of(checkedTicket));
        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository);
        //when
        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
        //then
        assertThat(verifiedTicket.message().message).isEqualTo("You have won the fourth prize!");
    }

    @Test
    public void should_return_info_that_user_did_not_win_the_prize() {
        //given
        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2);
        CheckedTicket checkedTicket = mock(CheckedTicket.class);
        given(checkedTicket.getLotteryId()).willReturn(exemplaryId);
        given(checkedTicket.getNumbersOfHits()).willReturn(exemplaryNumbersOfHits);
        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(checkedTicket);
        given(resultCheckerFacade.checkResult()).willReturn(List.of(checkedTicket));
        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository);
        //when
        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
        //then
        assertThat(verifiedTicket.message().message).isEqualTo("Keep playing");
    }

    UUID exemplaryId = UUID.fromString("123e4567-e89b-42d3-a456-556642440000");


}
