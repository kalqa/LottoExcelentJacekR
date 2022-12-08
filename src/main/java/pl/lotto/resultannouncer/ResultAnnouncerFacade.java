package pl.lotto.resultannouncer;

import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.CheckedTicket;
import pl.lotto.resultchecker.ResultCheckerFacade;

import java.util.UUID;

public class ResultAnnouncerFacade {
    ResultCheckerFacade resultCheckerFacade;
    ResultAnnouncerSummarizer resultAnnouncerSummarizer;
    ResultAnnouncerRepository resultAnnouncerRepository;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade, ResultAnnouncerSummarizer resultAnnouncerSummarizer,
                                 ResultAnnouncerRepository resultAnnouncerRepository) {
        this.resultCheckerFacade = resultCheckerFacade;
        this.resultAnnouncerSummarizer = resultAnnouncerSummarizer;
        this.resultAnnouncerRepository = resultAnnouncerRepository;
    }

    public ResultAnnouncerDto verifyTicket(UUID id) {
        CheckedTicket checkedTicket = resultCheckerFacade.checkUniqueTicket(id);
        ResultAnnouncerDto result = resultAnnouncerSummarizer.summarizeUniqueTicket(checkedTicket);
        resultAnnouncerRepository.save(result);
        return result;
    }
}
