package com.adolfoeloy;

import java.util.*;
import java.util.stream.Collectors;

public class FileSystem {
    private final Node root;

    public FileSystem() {
        this.root = new Node();
        this.root.isDir = true;
    }

    private static class Node {
        boolean isDir;
        boolean isFile;
        String name;
        String content;
        Map<String, Node> children;

        Node() {
            this.children = new HashMap<>();
        }

        static Node newDirectory() {
            Node n = new Node();
            n.isDir = true;
            return n;
        }

        static Node newFile() {
            Node n = new Node();
            n.isFile = true;
            return n;
        }
    }

    public List<String> ls(String path) {
        Node node = root;
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            Node child = node.children.get(token);
            if (child != null) {
                node = child;
            }
        }
        if (node.isDir) {
            return node.children.keySet().stream().sorted().collect(Collectors.toList());
        }
        return Collections.singletonList(node.name);
    }

    public void mkdir(String path) {
        addEntry(path, true);
    }

    public void addContentToFile(String filePath, String content) {
        Node file = addEntry(filePath, false);
        assert(file.isFile);

        if (file.content == null) {
            file.content = content;
        } else {
            file.content += content;
        }
    }

    public String readContentFromFile(String filePath) {
        Node node = root;
        StringTokenizer tokenizer = new StringTokenizer(filePath, "/");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            Node child = node.children.get(token);
            if (child != null) {
                node = child;
            } else {
                return null;
            }
        }
        if (node.isDir) return null;
        return node.content;
    }

    private Node addEntry(String path, boolean isDirectory) {
        Node node = root;

        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            Node child = node.children.get(token);
            if (child != null) {
                node = child;
            } else {
                Node newNode = isDirectory ? Node.newDirectory() : Node.newFile();
                newNode.name = token;

                node.children.put(token, newNode);
                node = newNode;
            }
        }

        return node;
    }
}
