package com.sahil.journalApplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthCheck {
    @GetMapping("/Health-Check")
    public String healthCheck(){
        return "All Ok";
    }
}
