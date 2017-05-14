package com.mcnaughton.bbc.service;

import com.mcnaughton.bbc.service.models.ElectionResults;

import java.util.UUID;

public interface ElectionService {

    public void voteInElection(UUID userId, UUID candidateId) throws Exception;
    public ElectionResults getElectionResults();
}
