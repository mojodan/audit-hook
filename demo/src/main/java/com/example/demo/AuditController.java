package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditController {

    @GetMapping("greeting")
    public String getMethodName() {
        return "Hello World from Codespaces";
    }

}
