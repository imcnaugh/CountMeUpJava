package com.mcnaughton.bbc.models;

import java.util.UUID;

public class Vote extends BaseModel {

    private UUID candidateId;
    private UUID userId;

    public Vote(UUID id, UUID userId, UUID candidateId){
        super(id);
        this.userId = userId;
        this.candidateId = candidateId;
    }

    public UUID getCandidateId(){
        return candidateId;
    }

    public UUID getUserId(){
        return userId;
    }
}
