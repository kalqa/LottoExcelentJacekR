//package pl.lotto.resultannouncer;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
//import pl.lotto.resultchecker.CheckedTicket;
//import pl.lotto.resultchecker.ResultCheckerFacade;
//import pl.lotto.resultchecker.ResultCheckerRepository;
//import pl.lotto.resultchecker.dto.CheckedTicketDto;
//import pl.lotto.resultchecker.dto.TicketStateDto;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import java.util.UUID;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.mock;
//
//public class ResultAnnouncerFacadeTest {
//
//
//    @Test
//    public void should_return_info_that_user_won_main_prize() {
//        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3, 4, 5, 6);
//        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
//        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(new UniqueTicketResultDto(
//                new CheckedTicketDto(exemplaryId, exemplaryDate, numbersFromUser,
//                        exemplaryNumbersOfHits), TicketStateDto.CHECKED));
//        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
//        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
//        ResultCheckerRepository  resultCheckerRepository = mock(ResultCheckerRepository.class);
//        given(resultCheckerRepository.findById(exemplaryId)).willReturn(Optional.of(new CheckedTicket(exemplaryId,
//                exemplaryDate, numbersFromUser, exemplaryNumbersOfHits)));
//        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(
//                resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository, resultCheckerRepository);
//        //when
//        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
//        //then
//        assertThat(verifiedTicket.message().message).isEqualTo("You won the main prize!");
//    }
//
//    @Test
//    public void should_return_info_that_user_won_second_prize() {
//        //given
//        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3, 4, 5);
//        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
//        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(new UniqueTicketResultDto(
//                new CheckedTicketDto(exemplaryId, exemplaryDate, numbersFromUser,
//                        exemplaryNumbersOfHits), TicketStateDto.CHECKED));
//        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
//        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
//        ResultCheckerRepository  resultCheckerRepository = mock(ResultCheckerRepository.class);
//        given(resultCheckerRepository.findById(exemplaryId)).willReturn(Optional.of(new CheckedTicket(exemplaryId,
//                exemplaryDate, numbersFromUser, exemplaryNumbersOfHits)));
//        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(
//                resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository, resultCheckerRepository);
//        //when
//        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
//        //then
//        assertThat(verifiedTicket.message().message).isEqualTo("You have won the second prize!");
//    }
//
//    @Test
//    public void should_return_info_that_user_won_third_prize() {
//        //given
//        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3, 4);
//        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
//        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(new UniqueTicketResultDto(
//                new CheckedTicketDto(exemplaryId, exemplaryDate, numbersFromUser,
//                        exemplaryNumbersOfHits), TicketStateDto.CHECKED));
//        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
//        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
//        ResultCheckerRepository  resultCheckerRepository = mock(ResultCheckerRepository.class);
//        given(resultCheckerRepository.findById(exemplaryId)).willReturn(Optional.of(new CheckedTicket(exemplaryId,
//                exemplaryDate, numbersFromUser, exemplaryNumbersOfHits)));
//        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(
//                resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository, resultCheckerRepository);
//        //when
//        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
//        //then
//        assertThat(verifiedTicket.message().message).isEqualTo("You have won the third prize!");
//    }
//
//    @Test
//    public void should_return_info_that_user_won_fourth_prize() {
//        //given
//        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2, 3);
//        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
//        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(new UniqueTicketResultDto(
//                new CheckedTicketDto(exemplaryId, exemplaryDate, numbersFromUser,
//                        exemplaryNumbersOfHits), TicketStateDto.CHECKED));
//        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
//        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
//        ResultCheckerRepository  resultCheckerRepository = mock(ResultCheckerRepository.class);
//        given(resultCheckerRepository.findById(exemplaryId)).willReturn(Optional.of(new CheckedTicket(exemplaryId,
//                exemplaryDate, numbersFromUser, exemplaryNumbersOfHits)));
//        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(
//                resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository, resultCheckerRepository);
//        //when
//        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
//        //then
//        assertThat(verifiedTicket.message().message).isEqualTo("You have won the fourth prize!");
//    }
//
//    @Test
//    public void should_return_info_that_user_did_not_win_the_prize() {
//        //given
//        Set<Integer> exemplaryNumbersOfHits = Set.of(1, 2);
//        ResultCheckerFacade resultCheckerFacade = mock(ResultCheckerFacade.class);
//        given(resultCheckerFacade.checkUniqueTicket(exemplaryId)).willReturn(new UniqueTicketResultDto(
//                new CheckedTicketDto(exemplaryId, exemplaryDate, numbersFromUser,
//                        exemplaryNumbersOfHits), TicketStateDto.CHECKED));
//        ResultAnnouncerSummarizer resultAnnouncerSummarizer = new ResultAnnouncerSummarizer();
//        ResultAnnouncerRepository resultAnnouncerRepository = mock(ResultAnnouncerRepository.class);
//        ResultCheckerRepository  resultCheckerRepository = mock(ResultCheckerRepository.class);
//        given(resultCheckerRepository.findById(exemplaryId)).willReturn(Optional.of(new CheckedTicket(exemplaryId,
//                exemplaryDate, numbersFromUser, exemplaryNumbersOfHits)));
//        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(
//                resultCheckerFacade, resultAnnouncerSummarizer, resultAnnouncerRepository, resultCheckerRepository);
//        //when
//        ResultAnnouncerDto verifiedTicket = resultAnnouncerFacade.verifyTicket(exemplaryId);
//        //then
//        assertThat(verifiedTicket.message().message).isEqualTo("Keep playing");
//    }
//
//    UUID exemplaryId = UUID.fromString("123e4567-e89b-42d3-a456-556642440000");
//    List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
//    LocalDateTime exemplaryDate = LocalDateTime.of(2022, 12, 24, 12, 0);
//
//
//}
