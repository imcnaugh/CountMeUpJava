package test.mcnaughton.bbc.controllers;

import test.mcnaughton.bbc.models.User;
import test.mcnaughton.bbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userIdString}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userIdString") String userIdString){
        UUID userId = UUID.fromString(userIdString);
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User createUser(@RequestParam("userName") String userName){
        return userService.addUser(userName);
    }

}
