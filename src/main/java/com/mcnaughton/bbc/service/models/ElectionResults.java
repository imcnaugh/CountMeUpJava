package com.mcnaughton.bbc.service.models;

import com.mcnaughton.bbc.models.Candidate;

import java.util.Map;

public class ElectionResults {
    public Map<Candidate, Integer> votesPerCandidate;
    public int totalVotes;

    public ElectionResults(Map<Candidate, Integer> votesPerCandidate, int totalVotes){
        this.votesPerCandidate = votesPerCandidate;
        this.totalVotes = totalVotes;
    }
}
