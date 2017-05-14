package com.mcnaughton.bbc.controllers;

import com.mcnaughton.bbc.service.ElectionService;
import com.mcnaughton.bbc.service.models.ElectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/election")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ElectionResults getElectionResults(){
        return electionService.getElectionResults();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity voteInElection(
            @RequestParam("userId") String userIdString,
            @RequestParam("candidateId") String candidateIdString){
        UUID userId = UUID.fromString(userIdString);
        UUID candidateId = UUID.fromString(candidateIdString);

        try {
            electionService.voteInElection(userId, candidateId);
        } catch (Exception e) {
            return new ResponseEntity<>("Reached mamimum votes", HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok("successful vote");
    }
}
