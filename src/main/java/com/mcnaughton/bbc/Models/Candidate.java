package com.mcnaughton.bbc.Models;

import java.util.UUID;

public class Candidate extends BaseModel{

    private String name;

    public Candidate(UUID id, String name){
        super(id);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
