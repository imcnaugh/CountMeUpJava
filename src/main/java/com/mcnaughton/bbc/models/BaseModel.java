package com.mcnaughton.bbc.models;

import java.util.UUID;

public abstract class BaseModel {
    private UUID id;

    public BaseModel(UUID id){
        this.id = id;
    }

    public UUID getId(){
        return id;
    }
}
