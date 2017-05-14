package com.mcnaughton.bbc.models;

import java.util.UUID;

public class User extends BaseModel {

    private String name;

    public User(UUID id, String name){
        super(id);
        this.name = name;
    }


}
