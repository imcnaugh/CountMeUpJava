package test.mcnaughton.bbc.domain;

import org.junit.Test;
import test.mcnaughton.bbc.domain.impl.InMemCandidateDao;
import test.mcnaughton.bbc.models.Candidate;

import static org.junit.Assert.*;

public class TestCandidateDao {

    private CandidateDao candidateDao = new InMemCandidateDao();

    @Test
    public void testAddCandidate(){
        String candidateName = "Candidate1";

        Candidate newCandidate = candidateDao.addCandidate(candidateName);

        assertEquals(candidateName, newCandidate.getName());
        assertNotNull(newCandidate.getId());
    }

    @Test
    public void testGetCandidate(){
        String candidateName = "candidate1";
        Candidate newCandidate = candidateDao.addCandidate(candidateName);

        Candidate retrivedCandidate = candidateDao.getCandidate(newCandidate.getId());

        assertEquals(newCandidate, retrivedCandidate);
    }

}
