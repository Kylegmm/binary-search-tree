package com.keyin.bts.service;

import com.keyin.bts.entity.TreeEntity;
import com.keyin.bts.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    // Create a binary search tree from a list of numbers and save it
    public TreeEntity createTree(List<Integer> numbers) {
        TreeEntity treeEntity = new TreeEntity();
        treeEntity.setInputNumbers(numbers.toString());
        treeEntity.setTreeStructure(generateTreeStructure(numbers)); // Generate JSON structure
        return treeRepository.save(treeEntity);
    }

    // Save a tree directly
    public TreeEntity saveTree(TreeEntity tree) {
        return treeRepository.save(tree);
    }

    // Retrieve all trees from the database
    public List<TreeEntity> getAllTrees() {
        return treeRepository.findAll();
    }

    // Utility to generate a JSON tree structure from a list of numbers
    private String generateTreeStructure(List<Integer> numbers) {
        // Build a binary search tree and convert to JSON format
        Node root = null;
        for (Integer number : numbers) {
            root = insertNode(root, number);
        }
        return convertToJson(root);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    private String convertToJson(Node root) {
        if (root == null) {
            return "null";
        }
        return String.format(
                "{\"value\":%d,\"left\":%s,\"right\":%s}",
                root.value,
                convertToJson(root.left),
                convertToJson(root.right)
        );
    }

    // Helper class for binary tree nodes
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}
