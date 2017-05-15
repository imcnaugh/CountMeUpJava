package test.mcnaughton.bbc.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.mcnaughton.bbc.domain.CandidateDao;
import test.mcnaughton.bbc.domain.UserDao;
import test.mcnaughton.bbc.domain.VoteDao;
import test.mcnaughton.bbc.models.Candidate;
import test.mcnaughton.bbc.models.User;
import test.mcnaughton.bbc.models.Vote;
import test.mcnaughton.bbc.service.impl.ElectionServiceImpl;
import test.mcnaughton.bbc.service.models.ElectionResults;

import javax.annotation.Resource;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestElectionService {

    @Mock
    private CandidateDao candidateDao;

    @Mock
    private UserDao userDao;

    @Mock
    private VoteDao voteDao;

    @InjectMocks
    @Resource
    private ElectionServiceImpl electionService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVoteInElectionHappyPath() throws Exception {
        User user = new User(UUID.randomUUID(), "testName");
        Candidate candidate = new Candidate(UUID.randomUUID(), "testCandidate)");

        when(userDao.getUser(user.getId())).thenReturn(user);
        when(candidateDao.getCandidate(candidate.getId())).thenReturn(candidate);

        when(voteDao.addVote(user.getId(), candidate.getId()))
                .thenReturn(new Vote(UUID.randomUUID(), user.getId(), candidate.getId()));

        int userVoteTimesBeforeVote = user.getNumTimesVoted();

        electionService.voteInElection(user.getId(), candidate.getId());

        verify(userDao, times(1)).getUser(user.getId());
        verify(candidateDao, times(1)).getCandidate(candidate.getId());
        verify(voteDao, times(1)).addVote(user.getId(), candidate.getId());

        assertEquals(user.getNumTimesVoted() , (userVoteTimesBeforeVote + 1));
    }

    @Test(expected = Exception.class)
    public void testVoteInElectionInvalidUser() throws Exception{
        when(userDao.getUser(anyObject())).thenReturn(null);
        electionService.voteInElection(UUID.randomUUID(), UUID.randomUUID());
    }

    @Test(expected = Exception.class)
    public void testVoteInElectionInvalidCandidate() throws Exception {
        User user = new User(UUID.randomUUID(), "test name");
        when(userDao.getUser(user.getId())).thenReturn(user);
        when(candidateDao.getCandidate(anyObject())).thenReturn(null);
        electionService.voteInElection(user.getId(), UUID.randomUUID());
    }

    @Test(expected = Exception.class)
    public void testVoteInElectionReachedMaxVotesForUser() throws Exception {
        User user = new User(UUID.randomUUID(), "eager voter");
        do{
            user.userVoted();
        } while(user.getNumTimesVoted() < 3);

        Candidate candidate = new Candidate(UUID.randomUUID(), "test candidate");
        when(userDao.getUser(user.getId())).thenReturn(user);
        when(candidateDao.getCandidate(candidate.getId())).thenReturn(candidate);

        electionService.voteInElection(user.getId(), candidate.getId());
    }

    @Test
    public void testGetElectionResults() throws Exception{
        User user = new User(UUID.randomUUID(), "test User");
        Candidate c1 = new Candidate(UUID.randomUUID(), "candidate 1");
        Candidate c2 = new Candidate(UUID.randomUUID(), "candidate 2");

        when(userDao.getUser(user.getId())).thenReturn(user);
        when(candidateDao.getCandidate(c1.getId())).thenReturn(c1);
        when(candidateDao.getCandidate(c2.getId())).thenReturn(c2);

        ElectionResults preVoteResults = electionService.getElectionResults();

        assertEquals(preVoteResults.totalVotes, 0);
        preVoteResults.votesPerCandidate.forEach(cv -> {
            assertEquals(cv.getVotes(), 0);
        });

        electionService.voteInElection(user.getId(), c1.getId());

        ElectionResults resultsAfterOneVote = electionService.getElectionResults();
        resultsAfterOneVote.votesPerCandidate.forEach(cv ->{
            if(cv.getCandidate().getId() == c1.getId()){
                assertEquals(cv.getVotes(), 1);
            } else {
                assertEquals(cv.getVotes(), 0);
            }
        });
        assertEquals(resultsAfterOneVote.totalVotes, 1);
    }

}
