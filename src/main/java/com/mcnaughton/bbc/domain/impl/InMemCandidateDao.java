package com.mcnaughton.bbc.domain.impl;

import com.mcnaughton.bbc.models.Candidate;
import com.mcnaughton.bbc.domain.CandidateDao;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
public class InMemCandidateDao implements CandidateDao{

    private Map<UUID, Candidate> dataStore = DataStorage.candidateDataStore;

    @Override
    public Candidate addCandidate(String name) {
        UUID id = DataStorage.getUniqueId(dataStore);
        Candidate newCandidate = new Candidate(id, name);
        dataStore.put(id, newCandidate);
        return newCandidate;
    }

    @Override
    public Candidate getCandidate(UUID id) {
        return dataStore.get(id);
    }
}
