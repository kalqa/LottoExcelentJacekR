package pl.lotto.resultannouncer;

import org.springframework.stereotype.Component;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.CheckedTicket;
import pl.lotto.resultchecker.ResultCheckerFacade;
import pl.lotto.resultchecker.ResultCheckerRepository;
import pl.lotto.resultchecker.dto.CheckedTicketDto;

import java.util.Optional;
import java.util.UUID;

@Component
public class ResultAnnouncerFacade {

    private final ResultCheckerFacade resultCheckerFacade;
    private final ResultAnnouncerSummarizer resultAnnouncerSummarizer;
    private final ResultAnnouncerRepository resultAnnouncerRepository;

    private final ResultCheckerRepository resultCheckerRepository;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade, ResultAnnouncerSummarizer resultAnnouncerSummarizer,
                                 ResultAnnouncerRepository resultAnnouncerRepository, ResultCheckerRepository resultCheckerRepository) {
        this.resultCheckerFacade = resultCheckerFacade;
        this.resultAnnouncerSummarizer = resultAnnouncerSummarizer;
        this.resultAnnouncerRepository = resultAnnouncerRepository;
        this.resultCheckerRepository = resultCheckerRepository;
    }

    public ResultAnnouncerDto verifyTicket(UUID id) {
        UniqueTicketResultDto uniqueTicketResultDto = resultCheckerFacade.checkUniqueTicket(id);
        if (uniqueTicketResultDto.ticketStateDto().isNotFound()) {
            return new ResultAnnouncerDto(null, AnnouncerMessages.NOT_FOUND);
        }
        if (uniqueTicketResultDto.ticketStateDto().isTooEarly()) {
            return new ResultAnnouncerDto(null, AnnouncerMessages.TOO_EARLY);
        }
        Optional<CheckedTicket> byId = resultCheckerRepository.findById(id);
            CheckedTicket checkedTicket = byId.get();
            ResultAnnouncerDto result = resultAnnouncerSummarizer.summarizeUniqueTicket(
                    new CheckedTicketDto(checkedTicket.getLotteryId(), checkedTicket.getDrawDate(),
                            checkedTicket.getNumbersFromUser(), checkedTicket.getNumbersOfHits()));
            resultAnnouncerRepository.save(result);
            return result;
        }
}
