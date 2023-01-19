package pl.lotto.feature;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import pl.lotto.BaseIntegrationTest;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import pl.lotto.resultannouncer.AnnouncerMessages;
import pl.lotto.resultannouncer.ResultAnnouncerFacade;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultannouncer.dto.TicketAnnouncerDto;
import pl.lotto.resultchecker.ResultCheckerFacade;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LottoWinnerSpec extends BaseIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void should_user_play_and_check_win_after_some_days() throws Exception {
        // STEP 1: when user input 6 correct numbers (1,2,3,4,5,6) (in range 1-99) to POST /inputNumbers
        // STEP 2 system returns unique random userLotteryId and returned draw 10-12-2022 to user
        // given
//        NumberReceiverFacade numberReceiverFacade = mock(NumberReceiverFacade.class);
//        given(numberReceiverFacade.generateLotteryUniqueId()).willReturn(UUID.fromString("23d69703-2396-470b-8152-e915917d5327"));

        // when
        ResultActions perform = mockMvc.perform(post("/inputNumbers")
                .content("{\"numbers\":[1,2,3,4,5,6]}")
                .contentType(MediaType.APPLICATION_JSON_VALUE));
        // then
        MvcResult mvcResult = perform
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(
                        "{\"message\":\"success\"," +
                                "\"drawDate\":\"2022-12-24T12:00:00\"}"))
//                .json(
//                        "{\"message\":\"success\"," +
//                                "\"lotteryId\": \"23d69703-2396-470b-8152-e915917d5327\",\n" +
//                                "\"drawDate\":\"2022-12-24T12:00:00\"}"))
                .andReturn();

//        Mockito.verify(numberReceiverFacade, Mockito.times(1)).generateLotteryUniqueId();

        String json = mvcResult.getResponse().getContentAsString();
        NumberReceiverResultDto result = objectMapper.readValue(json, NumberReceiverResultDto.class);
        // STEP 3 system generates random winning numbers (1,2,3,4,5,6) using “lotto” logic for 10-12-2022, winning numbers are generated every saturday at 11:30
        // when
        await().atMost(10, SECONDS)
                .pollInterval(Duration.ofSeconds(1))
                .until(() -> !luckyNumbersGeneratorFacade.retrieve(result.drawDate()).winningNumbers().isEmpty());


        // STEP 4 user wants to know if won using GET /winners/{userLotteryId} but before draw
        // given
        // when
        // then
        ResultActions perform2 = mockMvc.perform(get("/winners/" + result.lotteryId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"ticketAnnounce":null,"message":"NOT_FOUND"}
                        """))
                .andExpect(status().isNoContent());


        // STEP 5 system checkedWinner
        // given
        // when
        // then

        await().atMost(10, SECONDS)
                .pollInterval(Duration.ofSeconds(1))
                .until(() -> !resultCheckerFacade.checkResult().isEmpty());
        // STEP 6 user wants to know if won using GET /winners/{userLotteryId} after draw

        // given
        //        given(result.lotteryId()).willReturn(UUID.fromString("e0e3d2f1-c3e3-4f7c-9c97-a7e8c6c3d7f1"));

//        ResultAnnouncerFacade resultAnnouncerFacade = mock(ResultAnnouncerFacade.class);
//        given(resultAnnouncerFacade.verifyTicket(result.lotteryId())).willReturn(new ResultAnnouncerDto(new TicketAnnouncerDto(result.lotteryId(),
//                result.drawDate(), List.of(1,2,3,4,5,6), Set.of(1,2,3,4,5,6)), AnnouncerMessages.MAIN_PRIZE));

        // when
        ResultActions perform3 = mockMvc.perform(get("/winners/" + result.lotteryId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"message":"MAIN_PRIZE"}
                        """))
                .andExpect(status().isOk());
        // then

//"lotteryId":"e0e3d2f1-c3e3-4f7c-9c97-a7e8c6c3d7f1","drawDate":"2022-12-24T12:00:00","numbersFromUser":[1, 2, 3, 4, 5, 6],"numbersOfHits":"[1, 2, 3, 4, 5, 6]"}

    }
}
