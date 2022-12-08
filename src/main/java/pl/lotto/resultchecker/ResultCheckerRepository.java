package pl.lotto.resultchecker;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ResultCheckerRepository {

    void saveAll(List<CheckedTicket> checkedTickets);

    List<CheckedTicket> findAllByDate(LocalDateTime date);

    CheckedTicket findById(UUID id);
}

