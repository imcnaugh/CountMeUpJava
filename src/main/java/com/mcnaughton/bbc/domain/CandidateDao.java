package com.mcnaughton.bbc.domain;

import com.mcnaughton.bbc.models.Candidate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidateDao {

    public Candidate addCandidate(String name);
    public Candidate getCandidate(UUID id);
}
