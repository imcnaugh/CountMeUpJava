package com.mcnaughton.bbc.service.impl;

import com.mcnaughton.bbc.domain.CandidateDao;
import com.mcnaughton.bbc.domain.UserDao;
import com.mcnaughton.bbc.domain.VoteDao;
import com.mcnaughton.bbc.models.Candidate;
import com.mcnaughton.bbc.models.User;
import com.mcnaughton.bbc.service.ElectionService;
import com.mcnaughton.bbc.service.models.CandidateVotes;
import com.mcnaughton.bbc.service.models.ElectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElectionServiceImpl implements ElectionService{

    @Autowired
    private CandidateDao candidateDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private VoteDao voteDao;

    private final int VOTE_THRESHOLD = 3;
    private Map<UUID, Integer> cachedVoteResults = new HashMap<>();

    @Override
    public void voteInElection(UUID userId, UUID candidateId) throws Exception {

        User user = userDao.getUser(userId);
        if(user == null){
            //TODO throw better exception
            throw new Exception("User does not exists");
        }

        Candidate candidate = candidateDao.getCandidate(candidateId);
        if(candidate == null){
            //TODO throw better exception
            throw new Exception("candidate does not exists");
        }

        int userVoteCount = voteDao.getVoteCountForUser(userId);
        if(userVoteCount >= VOTE_THRESHOLD){
            //TODO throw better exceptions
            throw new Exception("exceeded votes for this user");
        }

        voteDao.addVote(userId, candidateId);
        if(cachedVoteResults.get(candidateId) == null){
            cachedVoteResults.put(candidateId, 0);
        }
        cachedVoteResults.put(candidateId, cachedVoteResults.get(candidateId) + 1);
    }

    @Override
    public ElectionResults getElectionResults() {
        List<CandidateVotes> candidateVotesInElection = new ArrayList<>();
        cachedVoteResults.forEach((id, count) -> {
            candidateVotesInElection.add(new CandidateVotes(candidateDao.getCandidate(id), count));
        });
        int totalVotes = cachedVoteResults.values().stream().mapToInt(i -> i.intValue()).sum();

        return new ElectionResults(candidateVotesInElection, totalVotes);
    }
}
