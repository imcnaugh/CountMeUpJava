package test.mcnaughton.bbc.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.mcnaughton.bbc.domain.CandidateDao;
import test.mcnaughton.bbc.models.Candidate;
import test.mcnaughton.bbc.service.impl.CandidateServiceImpl;

import javax.annotation.Resource;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TestCandidateService {

    @Mock
    private CandidateDao candidateDao;

    @InjectMocks
    @Resource
    private CandidateServiceImpl candidateService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCandidate(){
        String candidateName = "Anyone other then trump";
        when(candidateDao.addCandidate(candidateName)).thenReturn(
                new Candidate(UUID.randomUUID(), candidateName));
        Candidate newCandidate = candidateDao.addCandidate(candidateName);
        verify(candidateDao, times(1)).addCandidate(candidateName);
        assertEquals(newCandidate.getName(), candidateName);
        assertNotNull(newCandidate.getId());
    }

    @Test
    public void testGetCandidate(){
        Candidate candidate = new Candidate(UUID.randomUUID(), "testName");
        when(candidateDao.getCandidate(candidate.getId())).thenReturn(candidate);

        Candidate retrivedCandidate = candidateDao.getCandidate(candidate.getId());

        verify(candidateDao, times(1)).getCandidate(candidate.getId());
        assertEquals(candidate, retrivedCandidate);
    }

}
