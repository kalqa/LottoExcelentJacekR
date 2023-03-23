package pl.lotto.resultchecker;


import java.time.LocalDateTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResultCheckerRepository extends MongoRepository<CheckedTicket, UUID> {

    Optional<CheckedTicket> findById(UUID id);

    boolean existsByDrawDate(LocalDateTime drawDate);
}
