package com.keyin.bts.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BinarySearchTree {

    // Include only non-null fields in the JSON
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // Insert a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive insertion logic
    private Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Serialize the BST to JSON format
    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(root); // Serialize the root node
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
