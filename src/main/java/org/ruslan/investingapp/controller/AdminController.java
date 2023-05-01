package org.ruslan.investingapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("{}", auth.getAuthorities().toString());
        return new ResponseEntity<>("Dashboard", HttpStatus.OK);
    }
}
