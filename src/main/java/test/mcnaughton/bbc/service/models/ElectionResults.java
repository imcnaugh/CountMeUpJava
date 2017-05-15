package test.mcnaughton.bbc.service.models;

import java.util.List;

public class ElectionResults {
    public List<CandidateVotes> votesPerCandidate;
    public int totalVotes;

    public ElectionResults(List<CandidateVotes> votesPerCandidate, int totalVotes){
        this.votesPerCandidate = votesPerCandidate;
        this.totalVotes = totalVotes;
    }
}
