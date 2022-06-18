package com.classproject.classprojectbackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleControler {

    @GetMapping("/getName")
    public ResponseEntity<String> getName(){

        return new ResponseEntity<String>("thayaan", HttpStatus.OK);
    }
}
