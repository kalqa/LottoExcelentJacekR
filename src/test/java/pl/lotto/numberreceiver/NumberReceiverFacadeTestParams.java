//package pl.lotto.numberreceiver;
//
//
//import junitparams.JUnitParamsRunner;
//import junitparams.Parameters;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import java.time.Clock;
//import java.util.List;
//import java.util.Objects;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(JUnitParamsRunner.class)
//public class NumberReceiverFacadeTestParams {
//private static Objects[] testValues(){
//    new Object()[]{ };
//}
//
//    Clock clock = Clock.systemDefaultZone();
//
//    @Test
//    @Parameters(method = "testValues")
//    public void inputNumbers(List<Integer> numbersFromUser, String expectedResult){
//        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration(clock).createForTests();
//        numberReceiverFacade.inputNumbers(numbersFromUser);
//        assertThat(expectedResult).isEqualTo("success");
//
//    }
//
//}
