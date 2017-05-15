package test.mcnaughton.bbc.service.models;

import java.util.List;

public class ElectionConfig {

    private List<String> candidateNames;
    private int totalVotes;

    public List<String> getCandidateNames() {
        return candidateNames;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setCandidateNames(List<String> candidateNames) {
        this.candidateNames = candidateNames;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }
}
