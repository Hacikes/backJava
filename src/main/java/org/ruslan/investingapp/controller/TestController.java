package org.ruslan.investingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test/smth")
public class TestController {

    @GetMapping
    public String getGreeting() {
        return "Hello";
    }
}
