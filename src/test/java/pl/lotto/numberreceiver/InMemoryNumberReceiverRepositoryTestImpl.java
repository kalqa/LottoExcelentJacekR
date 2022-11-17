package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryNumberReceiverRepositoryTestImpl implements NumberReceiverRepository {

    Map<UUID, LotteryTicket> database = new ConcurrentHashMap<>();

    @Override
    public LotteryTicket save(LotteryTicket lotteryTicket) {
        return database.put(lotteryTicket.getLotteryId(), lotteryTicket);
    }

    @Override
    public List<LotteryTicket> findAllByDate(LocalDateTime date) {
        return database.values()
                .stream()
                .filter(lotteryTicket -> lotteryTicket.getDrawDate().isEqual(date))
                .toList();
    }
}
