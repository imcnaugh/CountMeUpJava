package test.mcnaughton.bbc.service;

import test.mcnaughton.bbc.models.User;

import java.util.UUID;

public interface UserService {
    public User addUser(String name);
    public User getUser(UUID id);
}
