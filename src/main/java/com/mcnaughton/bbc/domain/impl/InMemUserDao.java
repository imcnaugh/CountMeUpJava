package com.mcnaughton.bbc.domain.impl;

import com.mcnaughton.bbc.models.User;
import com.mcnaughton.bbc.domain.UserDao;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
public class InMemUserDao implements UserDao{

    private Map<UUID, User> dataStore = DataStorage.userDataStore;

    @Override
    public User addUser(String name) {
        UUID id = DataStorage.getUniqueId(dataStore);

        User newUser = new User(id, name);
        dataStore.put(id, newUser);

        return newUser;
    }

    @Override
    public User getUser(UUID id){
        return dataStore.get(id);
    }
}
