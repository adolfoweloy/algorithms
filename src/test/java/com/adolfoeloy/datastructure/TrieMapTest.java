package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieMapTest {

    @Test
    void contains__should_return_true_for_added_words() {
        TrieMap trieMap = new TrieMap();
        trieMap.add("tree");
        trieMap.add("twins");

        assertTrue(trieMap.contains("tree"));
        assertTrue(trieMap.contains("twins"));
        assertFalse(trieMap.contains("ball"));
    }

    @Test
    void remove__should_remove_previously_added_word() {
        TrieMap trieMap = new TrieMap();
        trieMap.add("tree");
        trieMap.add("twins");

        assertTrue(trieMap.remove("twins"));
        assertTrue(trieMap.contains("tree"));
        assertFalse(trieMap.contains("twins"));
    }
}