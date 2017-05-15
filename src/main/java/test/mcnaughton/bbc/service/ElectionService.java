package test.mcnaughton.bbc.service;

import test.mcnaughton.bbc.service.models.ElectionConfig;
import test.mcnaughton.bbc.service.models.ElectionResults;

import java.util.UUID;

public interface ElectionService {

    public void voteInElection(UUID userId, UUID candidateId) throws Exception;
    public ElectionResults getElectionResults();
    public ElectionResults runTestElection(ElectionConfig config);
}
