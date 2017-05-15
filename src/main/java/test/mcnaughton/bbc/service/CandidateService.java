package test.mcnaughton.bbc.service;

import test.mcnaughton.bbc.models.Candidate;

import java.util.UUID;

public interface CandidateService {
    public Candidate addUser(String name);
    public Candidate getUser(UUID id);
}
