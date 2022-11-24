package pl.lotto.resultchecker;


import java.time.LocalDateTime;
import java.util.List;

public interface ResultCheckerRepository {

    CheckedTicket save(CheckedTicket checkedTicket);

    List<CheckedTicket> findAllByDate(LocalDateTime date);
}

