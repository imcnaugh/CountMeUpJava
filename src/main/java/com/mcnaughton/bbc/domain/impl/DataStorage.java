package com.mcnaughton.bbc.domain.impl;

import com.mcnaughton.bbc.models.BaseModel;
import com.mcnaughton.bbc.models.Candidate;
import com.mcnaughton.bbc.models.User;
import com.mcnaughton.bbc.models.Vote;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataStorage {

    protected final static Map<UUID, User> userDataStore = new HashMap<>();
    protected final static Map<UUID, Vote> voteDataStore = new HashMap<>();
    protected final static Map<UUID, Candidate> candidateDataStore = new HashMap<>();


    protected static UUID getUniqueId(Map<UUID, ? extends BaseModel> dataStore){
        UUID tempId = null;
        do{
            tempId = UUID.randomUUID();
        } while(dataStore.containsKey(tempId));
        return tempId;
    }

}
