package com.business_system.controller;

import com.business_system.service.CoreMLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CoreMLMController {

    @Autowired
    private CoreMLMService service;

    @PostMapping("/deposit")
    public Object deposit(@RequestParam Long userId, @RequestParam Double amount) {
        return service.deposit(userId, amount);
    }

    @PostMapping("/withdraw")
    public Object withdraw(@RequestParam Long userId, @RequestParam Double amount) {
        return service.withdraw(userId, amount);
    }
}
