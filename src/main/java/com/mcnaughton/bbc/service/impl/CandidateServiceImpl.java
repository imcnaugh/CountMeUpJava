package com.mcnaughton.bbc.service.impl;

import com.mcnaughton.bbc.domain.CandidateDao;
import com.mcnaughton.bbc.models.Candidate;
import com.mcnaughton.bbc.service.CandidateService;
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
