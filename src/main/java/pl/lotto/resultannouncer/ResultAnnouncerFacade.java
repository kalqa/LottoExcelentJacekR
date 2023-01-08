package pl.lotto.resultannouncer;

import org.springframework.stereotype.Component;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.CheckedTicket;
import pl.lotto.resultchecker.ResultCheckerFacade;

import java.util.Optional;
import java.util.UUID;

@Component
public class ResultAnnouncerFacade {

    private final ResultCheckerFacade resultCheckerFacade;
    private final ResultAnnouncerSummarizer resultAnnouncerSummarizer;
    private final ResultAnnouncerRepository resultAnnouncerRepository;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade, ResultAnnouncerSummarizer resultAnnouncerSummarizer,
                                 ResultAnnouncerRepository resultAnnouncerRepository) {
        this.resultCheckerFacade = resultCheckerFacade;
        this.resultAnnouncerSummarizer = resultAnnouncerSummarizer;
        this.resultAnnouncerRepository = resultAnnouncerRepository;
    }

    public ResultAnnouncerDto verifyTicket(UUID id) {
        Optional<CheckedTicket> checkedTicket = resultCheckerFacade.checkUniqueTicket(id);
        ResultAnnouncerDto result = resultAnnouncerSummarizer.summarizeUniqueTicket(checkedTicket);
        resultAnnouncerRepository.save(result);
        return result;
    }
}
