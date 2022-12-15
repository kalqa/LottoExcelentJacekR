package pl.lotto.feature;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import pl.lotto.BaseIntegrationTest;
import pl.lotto.LottoExcellentJacekRApplication;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = LottoExcellentJacekRApplication.class)
@Testcontainers
@AutoConfigureMockMvc
public class LottoWinnerSpec extends BaseIntegrationTest {

    @Container
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));

    @DynamicPropertySource
    private static void propertyOverride(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;


    @Test
    public void should_user_play_and_check_win_after_some_days() throws Exception {
        // STEP 1: when user input 6 correct numbers (1,2,3,4,5,6) (in range 1-99) to POST /inputNumbers
        // STEP 2 system returns unique random userLotteryId and returned draw 10-12-2022 to user
        // given
        // when
        ResultActions perform = mockMvc.perform(post("/inputNumbers")
                .content("{\"numbers\":[1,2,3,4,5,6]}")
                .contentType(MediaType.APPLICATION_JSON_VALUE));
        // then
        MvcResult mvcResult = perform
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"message\":\"success\"," +
                                "\"drawDate\":\"2022-12-17T12:00:00\"}"))
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        NumberReceiverResultDto result = objectMapper.readValue(json, NumberReceiverResultDto.class);
//        clock

        // STEP 3 system generates random winning numbers (1,2,3,4,5,6) using “lotto” logic for 10-12-2022, winning numbers are generated every saturday at 11:30
        // given
        // when
        // then



        // STEP 4 user wants to know and if won using GET /winners/{userLotteryId}
        // given
        // when
        // then

        // STEP 5 system returns won result to user
        // given
        // when
        // then

    }
}
