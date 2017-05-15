package test.mcnaughton.bbc.service.impl;

import test.mcnaughton.bbc.domain.CandidateDao;
import test.mcnaughton.bbc.models.Candidate;
import test.mcnaughton.bbc.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateDao candidateDao;

    @Override
    public Candidate addUser(String name) {
        return candidateDao.addCandidate(name);
    }

    @Override
    public Candidate getUser(UUID id) {
        return candidateDao.getCandidate(id);
    }
}
