package test.mcnaughton.bbc.domain.impl;

import test.mcnaughton.bbc.models.BaseModel;
import test.mcnaughton.bbc.models.Candidate;
import test.mcnaughton.bbc.models.User;
import test.mcnaughton.bbc.models.Vote;

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
