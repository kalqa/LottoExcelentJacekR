package pl.lotto.resultannouncer;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;

import java.util.List;

public interface ResultAnnouncerRepository {
    List<ResultAnnouncerDto> save(ResultAnnouncerDto summarizedTicket);
}
