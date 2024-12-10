package com.keyin.bts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.keyin.bts.entity.TreeEntity;
import com.keyin.bts.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the React frontend
public class TreeController {

    @Autowired
    private TreeService treeService;

    // Create a tree from a list of numbers and return the saved tree
    @PostMapping("/process-numbers")
    public TreeEntity processNumbers(@RequestBody List<Integer> numbers) {
        return treeService.createTree(numbers); // Calls service to create and save the tree
    }

    // Retrieve all previously saved trees
    @GetMapping("/previous-trees")
    public List<TreeEntity> getPreviousTrees() {
        return treeService.getAllTrees();
    }

    // Save a tree directly (e.g., from the frontend)
    @PostMapping("/save-tree")
    public ResponseEntity<TreeEntity> saveTree(@RequestBody TreeEntity tree) {
        TreeEntity savedTree = treeService.saveTree(tree); // Calls service to save the tree
        return ResponseEntity.ok(savedTree);
    }
}
