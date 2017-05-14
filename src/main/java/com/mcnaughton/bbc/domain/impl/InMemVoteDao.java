package com.mcnaughton.bbc.domain.impl;

import com.mcnaughton.bbc.models.Vote;
import com.mcnaughton.bbc.domain.VoteDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemVoteDao implements VoteDao {

    private Map<UUID, Vote> dataStore = DataStorage.voteDataStore;

    @Override
    public List<Vote> getVotesForElection() {
        return new ArrayList<Vote>(dataStore.values());
    }

    @Override
    public int getVoteCountForCandidate(UUID candidateId){
        return (int) dataStore.values().stream().filter(v -> v.getCandidateId().equals(candidateId)).count();
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
        return (int) dataStore.values().stream().filter(v -> v.getUserId().equals(userId)).count();
    }
}
