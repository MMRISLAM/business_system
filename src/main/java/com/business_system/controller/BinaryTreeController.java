package com.business_system.controller;

import com.business_system.model.BinaryTree;
import com.business_system.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tree")
public class BinaryTreeController {

    @Autowired
    private TreeService service;

    // ADD USER
    @PostMapping("/add")
    public BinaryTree add(
            @RequestParam Long userId,
            @RequestParam Long parentId,
            @RequestParam String position
    ) {
        return service.addUser(userId, parentId, position);
    }

    // DIRECT
    @GetMapping("/direct/{parentId}")
    public List<BinaryTree> direct(@PathVariable Long parentId) {
        return service.getDirectTree(parentId);
    }

    // FULL (15 users)
    @GetMapping("/all/{parentId}")
    public List<BinaryTree> all(@PathVariable Long parentId) {
        return service.getTree(parentId);
    }
}
