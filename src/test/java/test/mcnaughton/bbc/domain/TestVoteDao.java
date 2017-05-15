package test.mcnaughton.bbc.domain;

import org.junit.Test;
import test.mcnaughton.bbc.domain.impl.InMemVoteDao;
import test.mcnaughton.bbc.models.Vote;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class TestVoteDao {

    private VoteDao voteDao = new InMemVoteDao();

    @Test
    public void testAddVote(){
        UUID userId = UUID.randomUUID();
        UUID candidateId = UUID.randomUUID();

        Vote newVote = voteDao.addVote(userId, candidateId);

        assertEquals(newVote.getUserId(), userId);
        assertEquals(newVote.getCandidateId(), candidateId);
        assertNotNull(newVote.getId());
    }

    @Test
    public void testGetVoteForCandidate(){
        UUID userId = UUID.randomUUID();
        UUID candidate1Id = UUID.randomUUID();
        UUID candidate2Id = UUID.randomUUID();

        voteDao.addVote(userId, candidate1Id);
        voteDao.addVote(userId, candidate2Id);

        int voteForCandidate1 = voteDao.getVoteCountForCandidate(candidate1Id);
        assertEquals(voteForCandidate1, 1);
    }

    @Test
    public void testGetVoteForUser(){
        UUID user1Id = UUID.randomUUID();
        UUID user2Id = UUID.randomUUID();
        UUID candidateId = UUID.randomUUID();

        voteDao.addVote(user1Id, candidateId);
        voteDao.addVote(user2Id, candidateId);

        int voteCountForUser1 = voteDao.getVoteCountForUser(user1Id);
        assertEquals(voteCountForUser1, 1);
    }
}
