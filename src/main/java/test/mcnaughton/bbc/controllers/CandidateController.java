package test.mcnaughton.bbc.controllers;

import test.mcnaughton.bbc.models.Candidate;
import test.mcnaughton.bbc.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/{candidateId}", method = RequestMethod.GET)
    public Candidate getCandidage(String candidateIdString){
        UUID candidateId = UUID.fromString(candidateIdString);
        return candidateService.getUser(candidateId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Candidate addCandidage(@RequestParam String name){
        return candidateService.addUser(name);
    }

}
