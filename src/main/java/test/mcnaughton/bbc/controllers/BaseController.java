package test.mcnaughton.bbc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> testMethod(){
        return ResponseEntity.ok("hello world this is a test");
    }

}
