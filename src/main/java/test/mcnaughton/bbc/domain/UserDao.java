package test.mcnaughton.bbc.domain;

import test.mcnaughton.bbc.models.User;

import java.util.UUID;

public interface UserDao {

    public User addUser(String name);

    public User getUser(UUID id);
}
