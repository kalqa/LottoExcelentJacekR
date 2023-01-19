package pl.lotto.resultannouncer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResultAnnouncerRepository extends MongoRepository<ResultAnnouncerDto, UUID> {
}
