package com.mcnaughton.bbc.domain;

import com.mcnaughton.bbc.models.User;

import java.util.UUID;

public interface UserDao {

    public User addUser(String name);

    public User getUser(UUID id);
}
