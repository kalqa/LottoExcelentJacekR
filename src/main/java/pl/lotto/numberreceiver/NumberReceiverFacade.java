package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.DrawDateDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import static pl.lotto.numberreceiver.dto.NumberReceiverResultDto.failure;
import static pl.lotto.numberreceiver.dto.NumberReceiverResultDto.success;

public class NumberReceiverFacade {

    private static final String FAILURE_MESSAGE = "failure";
    private static final String SUCCESS_MESSAGE = "success";
    NumberInputValidator validator;
    DrawDateSelector drawDateSelector;
    LotteryIdGenerator lotteryIdGenerator;
    NumberReceiverRepository repository;

    NumberReceiverFacade(NumberInputValidator validator, DrawDateSelector drawDateSelector, LotteryIdGenerator lotteryIdGenerator, NumberReceiverRepository repository) {
        this.validator = validator;
        this.drawDateSelector = drawDateSelector;
        this.lotteryIdGenerator = lotteryIdGenerator;
        this.repository = repository;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        ValidationResult validate = validator.validate(numbersFromUser);
        if (validate.isNotValid()) {
            return failure(validate.message());
        }
        UUID lotteryId = generateLotteryUniqueId();
        LocalDateTime drawDate = drawDateSelector.specifyExactDateNextDraw();
        LotteryTicket lotteryTicket = new LotteryTicket(lotteryId, drawDate, numbersFromUser);
        repository.save(lotteryTicket);
        return success(validate.message(), lotteryId, drawDate);
    }

    public UUID generateLotteryUniqueId() {
        return LotteryIdGenerator.generateLotteryId();
    }

//    public AllNumbersFromUsersDto userNumbers(LocalDateTime date) {
//        List<LotteryTicket> allByDate = repository.findAllByDrawDate(date);
//        List<LotteryTicketDto> lotteryTicketDtos = allByDate.stream()
//                .map(lotteryTicket -> new LotteryTicketDto(
//                        lotteryTicket.getLotteryId(),
//                        lotteryTicket.getDrawDate(),
//                        lotteryTicket.getNumbersFromUser()))
//                .toList();
//        return new AllNumbersFromUsersDto(lotteryTicketDtos);
//    }

    public AllNumbersFromUsersDto userNumbersForNextDrawDate() {
        LocalDateTime localDateTime = drawDateSelector.specifyExactDateNextDraw();
        List<LotteryTicket> allByDate = repository.findAllByDrawDate(localDateTime);
        List<LotteryTicketDto> lotteryTicketDtos = allByDate.stream()
                .map(lotteryTicket -> new LotteryTicketDto(
                        lotteryTicket.getLotteryId(),
                        lotteryTicket.getDrawDate(),
                        lotteryTicket.getNumbersFromUser()))
                .toList();
        return new AllNumbersFromUsersDto(lotteryTicketDtos);
    }

    public DrawDateDto specifyDrawDate(){
        return new DrawDateDto(drawDateSelector.specifyExactDateNextDraw());
    }


}
