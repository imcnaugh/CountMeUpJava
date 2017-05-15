package test.mcnaughton.bbc.service.models;

import test.mcnaughton.bbc.models.Candidate;

public class CandidateVotes {
    private Candidate candidate;
    private int votes;

    public CandidateVotes(Candidate candidate, int votes){
        this.candidate = candidate;
        this.votes = votes;
    }

    public Candidate getCandidate(){
        return this.candidate;
    }

    public int getVotes(){
        return this.votes;
    }
}
