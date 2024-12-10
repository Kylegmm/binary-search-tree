package com.keyin.bts.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {

    @Test
    void testToJson() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        String json = bst.toJson();

        // Assert JSON contains tree structure
        assertNotEquals("{}", json, "JSON should not be empty");
        assertTrue(json.contains("\"value\":10"), "Root value should be serialized");
        assertTrue(json.contains("\"value\":5"), "Left child should be serialized");
        assertTrue(json.contains("\"value\":15"), "Right child should be serialized");
    }
}
