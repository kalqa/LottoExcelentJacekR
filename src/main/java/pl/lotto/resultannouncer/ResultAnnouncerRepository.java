package pl.lotto.resultannouncer;

import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;

import java.util.List;

public interface ResultAnnouncerRepository {
    List<ResultAnnouncerDto> save(ResultAnnouncerDto summarizedTicket);
}
