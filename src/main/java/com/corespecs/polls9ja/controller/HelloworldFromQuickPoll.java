package com.corespecs.polls9ja.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldFromQuickPoll {

    @RequestMapping("/greet")
    public String greet(){
        return "Hello world from Polls9ja";
    }
}
