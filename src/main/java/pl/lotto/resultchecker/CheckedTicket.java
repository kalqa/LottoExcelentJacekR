package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CheckedTicket {

    private final UUID lotteryId;
    private final LocalDateTime drawDate;
    private final List<Integer> numbersFromUser;
    private final Set<Integer> numbersOfHits;

    public CheckedTicket(UUID lotteryId, LocalDateTime drawDate, List<Integer> numbersFromUser, Set<Integer> numbersOfHits) {
        this.lotteryId = lotteryId;
        this.drawDate = drawDate;
        this.numbersFromUser = numbersFromUser;
        this.numbersOfHits = numbersOfHits;
    }

    public UUID getLotteryId() {
        return lotteryId;
    }

    public LocalDateTime getDrawDate() {
        return drawDate;
    }

    public List<Integer> getNumbersFromUser() {
        return numbersFromUser;
    }

    public Set<Integer> getNumbersOfHits() {
        return numbersOfHits;
    }
}
