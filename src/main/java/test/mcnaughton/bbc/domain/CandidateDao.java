package test.mcnaughton.bbc.domain;

import test.mcnaughton.bbc.models.Candidate;

import java.util.UUID;

public interface CandidateDao {

    public Candidate addCandidate(String name);
    public Candidate getCandidate(UUID id);
}
