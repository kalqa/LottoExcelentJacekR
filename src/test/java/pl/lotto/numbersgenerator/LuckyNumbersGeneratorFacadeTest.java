package pl.lotto.numbersgenerator;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyNumbersGeneratorFacadeTest {

    @Test
    public void should_return_required_size_of_set() {
        //given
        LuckyNumbersGeneratorFacade numbersGenerator = new LuckyNumbersGeneratorFacade();
        //when
        LuckyNumbersDto generatedNumbers = numbersGenerator.generateLuckyNumbers();
        //then
        assertThat(generatedNumbers.winningNumbers().size()).isEqualTo(6);
    }

    @Test
    public void should_generate_unique_numbers() {
        //given
        LuckyNumbersGeneratorFacade numbersGenerator = new LuckyNumbersGeneratorFacade();
        //when
        LuckyNumbersDto generatedNumbers = numbersGenerator.generateLuckyNumbers();
        //then
        assertThat(new HashSet<>(generatedNumbers.winningNumbers()).size()).isEqualTo(generatedNumbers.winningNumbers().size());
    }
}
