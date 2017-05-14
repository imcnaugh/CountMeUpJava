package com.mcnaughton.bbc.domain;

import com.mcnaughton.bbc.models.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDao {

    public User addUser(String name);

    public User getUser(UUID id);
}
