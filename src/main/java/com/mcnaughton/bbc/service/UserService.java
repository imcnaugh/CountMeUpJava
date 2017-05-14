package com.mcnaughton.bbc.service;

import com.mcnaughton.bbc.models.User;

import java.util.UUID;

public interface UserService {
    public User addUser(String name);
    public User getUser(UUID id);
}
