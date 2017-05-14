package com.mcnaughton.bbc.domain;

import com.mcnaughton.bbc.models.Vote;

import java.util.List;
import java.util.UUID;

public interface VoteDao {

    public List<Vote> getVotesForElection();
    public int getVoteCountForCandidate(UUID candidateId);
    public Vote addVote(UUID userId, UUID candidateId);
    public int getVoteCountForUser(UUID userId);
}
