package com.example.demo;

import java.util.Enumeration;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuditController {

    // GET endpoint at / that returns a simple greeting
    @GetMapping(value = {"/", ""})
    public String getGreeting() {
        return "Hello Ping";
    }
    

    @GetMapping("greeting")
    public String getMethodName() {
        System.out.println("basic greeting");
        return "Hello World from Codespaces";
    }

    @PostMapping(value = {"notifications/", "notifications"})
    public ResponseEntity<String> postNotifications(HttpServletRequest request, @RequestParam(required = false) String body, @RequestParam Map<String, String> queryParams) {
        // Log the current date and time.   
        System.out.println("Request received at: " + new java.util.Date());
        
        // Log HEAD request
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }

        // Log QUERY parameters
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            String paramName = entry.getKey();
            String paramValue = entry.getValue();
            System.out.println(paramName + ": " + paramValue);
        }
        
        // Log BODY
        if (body != null && !body.isEmpty()) {
            System.out.println("BODY: " + body);
        }

        System.out.println("-------------------");
        

        return ResponseEntity.ok().build();
    }


}
