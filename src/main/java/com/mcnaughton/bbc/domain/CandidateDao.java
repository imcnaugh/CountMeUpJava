package com.mcnaughton.bbc.domain;

import com.mcnaughton.bbc.Models.Candidate;

import java.util.UUID;

public interface CandidateDao {

    public Candidate addCandidate(String name);
    public Candidate getCandidate(UUID id);
}
