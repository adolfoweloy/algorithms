package com.adolfoeloy.datastructure;

public class TrieMap {

    private final Node root = new Node();

    private static class Node {
        char value;
        Node[] children;
        boolean isWord;

        private Node() {
            this('\0');
        }

        private Node(char value) {
            this.value= value;
            this.children = new Node[26];
            this.isWord = false;
        }
    }

    void add(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    boolean contains(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    boolean remove(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        node.isWord = false;
        return true;
    }
}
