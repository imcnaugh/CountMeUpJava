package test.mcnaughton.bbc.service.impl;

import test.mcnaughton.bbc.domain.CandidateDao;
import test.mcnaughton.bbc.domain.UserDao;
import test.mcnaughton.bbc.domain.VoteDao;
import test.mcnaughton.bbc.models.Candidate;
import test.mcnaughton.bbc.models.User;
import test.mcnaughton.bbc.service.ElectionService;
import test.mcnaughton.bbc.service.models.CandidateVotes;
import test.mcnaughton.bbc.service.models.ElectionConfig;
import test.mcnaughton.bbc.service.models.ElectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

        if(user.getNumTimesVoted() >= VOTE_THRESHOLD){
            //TODO throw better exceptions
            throw new Exception("exceeded votes for this user");
        }

        voteDao.addVote(userId, candidateId);
        if(cachedVoteResults.get(candidateId) == null){
            cachedVoteResults.put(candidateId, 0);
        }
        cachedVoteResults.put(candidateId, cachedVoteResults.get(candidateId) + 1);
        user.userVoted();
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

    @Override
    public ElectionResults runTestElection(ElectionConfig config) {
        List<Candidate> candidates =config.getCandidateNames().stream().map(candidateDao::addCandidate)
                .collect(Collectors.toList());
        User currentUser = userDao.addUser("");
        int currentVoteCountForUser = 0;
        for(int i = 0; i < config.getTotalVotes(); i++){
            if(currentVoteCountForUser >= 3){
                currentUser = userDao.addUser("");
            }
            try {
                voteInElection(currentUser.getId(), candidates.get((int) (Math.random() * candidates.size())).getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            currentVoteCountForUser++;
        }
        return getElectionResults();
    }
}
