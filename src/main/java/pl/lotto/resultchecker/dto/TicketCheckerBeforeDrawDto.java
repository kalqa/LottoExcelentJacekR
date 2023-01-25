package pl.lotto.resultchecker.dto;

import pl.lotto.numberreceiver.dto.LotteryTicketDto;

public record TicketCheckerBeforeDrawDto(

        LotteryTicketDto lotteryTicketDto,
        TicketStateDto ticketStateDto) {
}


