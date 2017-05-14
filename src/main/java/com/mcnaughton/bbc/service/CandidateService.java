package com.mcnaughton.bbc.service;

import com.mcnaughton.bbc.models.Candidate;

import java.util.UUID;

public interface CandidateService {
    public Candidate addUser(String name);
    public Candidate getUser(UUID id);
}
