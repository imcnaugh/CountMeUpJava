package com.mcnaughton.bbc.service.models;

import com.mcnaughton.bbc.models.Candidate;

import java.util.List;
import java.util.Map;

public class ElectionResults {
    public List<CandidateVotes> votesPerCandidate;
    public int totalVotes;

    public ElectionResults(List<CandidateVotes> votesPerCandidate, int totalVotes){
        this.votesPerCandidate = votesPerCandidate;
        this.totalVotes = totalVotes;
    }
}
