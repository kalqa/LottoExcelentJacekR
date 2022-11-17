package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


class LotteryTicket {
    private final UUID lotteryId;
    private final LocalDateTime drawDate;
    private final List<Integer> numbersFromUser;

    public LotteryTicket(UUID lotteryId, LocalDateTime drawDate, List<Integer> numbersFromUser) {
        this.lotteryId = lotteryId;
        this.drawDate = drawDate;
        this.numbersFromUser = numbersFromUser;
    }

    UUID getLotteryId() {
        return lotteryId;
    }

    LocalDateTime getDrawDate() {
        return drawDate;
    }

    List<Integer> getNumbersFromUser() {
        return numbersFromUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(lotteryId, that.lotteryId) && Objects.equals(drawDate, that.drawDate) && Objects.equals(numbersFromUser, that.numbersFromUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryId, drawDate, numbersFromUser);
    }
}
