package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CheckedTicket {

    public CheckedTicket(UUID lotteryId, LocalDateTime drawDate, List<Integer> numbersFromUser, List<Integer> numbersOfHits) {
        this.lotteryId = lotteryId;
        this.drawDate = drawDate;
        this.numbersFromUser = numbersFromUser;
        this.numbersOfHits = numbersOfHits;
    }

    private final UUID lotteryId;
    private final LocalDateTime drawDate;
    private final List<Integer> numbersFromUser;
    private final List<Integer> numbersOfHits;

    public UUID getLotteryId() {
        return lotteryId;
    }

    public LocalDateTime getDrawDate() {
        return drawDate;
    }

    public List<Integer> getNumbersFromUser() {
        return numbersFromUser;
    }

    public List<Integer> getNumbersOfHits() {
        return numbersOfHits;
    }
}
