package com.adolfoeloy;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class FileSystem {
    private final Directory root;

    public FileSystem() {
        this.root = new Directory();
    }

    private static class Directory {
        String name;
        Map<String, Directory> children = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        Directory directory = root;
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            Directory child = directory.children.get(token);
            if (child != null) {
                directory = child;
            } else {
                if (directory.files.containsKey(token)) {
                    return Collections.singletonList(token);
                }
            }
        }

        result.addAll(directory.children.keySet());
        result.addAll(directory.files.keySet());
        return result.stream().sorted().collect(Collectors.toList());
    }

    public void mkdir(String path) {
        addDirectory(path);
    }

    public void addContentToFile(String filePath, String content) {
        addFile(filePath, content);
    }

    public String readContentFromFile(String filePath) {
        Directory directory = root;
        StringTokenizer tokenizer = new StringTokenizer(filePath, "/");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            Directory child = directory.children.get(token);
            if (child != null) {
                directory = child;
            } else {
                return directory.files.getOrDefault(token, null);
            }
        }
        return null;
    }

    private void addFile(String path, String content) {
        addEntry(path, (fileName, dir) -> {
            dir.files.merge(fileName, content, (a, b) -> a + b);
            return dir;
        });
    }

    private void addDirectory(String path) {
        addEntry(path, (directoryName, dir) -> {
            Directory d = new Directory();
            d.name = directoryName;
            dir.children.put(directoryName, d);
            return d;
        });
    }

    private void addEntry(String path, BiFunction<String, Directory, Directory> add) {
        Directory directory = root;
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            Directory child = directory.children.get(token);
            if (child != null) {
                directory = child;
            } else {
                directory = add.apply(token, directory);
            }
        }
    }
}
