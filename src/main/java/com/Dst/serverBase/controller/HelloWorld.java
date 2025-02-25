package com.Dst.serverBase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class HelloWorld {

    @GetMapping
    ResponseEntity<String> home(){
        return ResponseEntity.ok("welcome to https://localhost:8080 server!!!");
    }
}
