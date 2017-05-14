package com.mcnaughton.bbc.domain.impl;

import com.mcnaughton.bbc.models.Vote;
import com.mcnaughton.bbc.domain.VoteDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InMemVoteDao implements VoteDao {

    private Map<UUID, Vote> dataStore = DataStorage.voteDataStore;

    @Override
    public List<Vote> getVotesForElection() {
        return new ArrayList<Vote>(dataStore.values());
    }

    @Override
    public int getVoteCountForCandidate(UUID candidateId){
        return (int) dataStore.values().stream().filter(v -> {
            return v.getCandidateId() == candidateId;
        }).count();
    }

    @Override
    public Vote addVote(UUID userId, UUID candidateId){
        UUID id = DataStorage.getUniqueId(dataStore);
        Vote newVote = new Vote(id, userId, candidateId);
        dataStore.put(id, newVote);
        return newVote;
    }

    @Override
    public int getVoteCountForUser(UUID userId){
        return (int) dataStore.values().stream().filter(v -> {
            return v.getCandidateId() == userId;
        }).count();
    }
}
