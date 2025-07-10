package com.adolfoeloy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DirectoryStructure {

    public record Directory(
        String name,
        List<Directory> children) {

        public void addChild(Directory child) {
            children.add(child);
        }

        public static Directory fromPath(String path) {
            if (path == null || path.isEmpty()) {
                throw new IllegalArgumentException("Path cannot be empty");
            }

            var parts = path.split("/");
            var root = singleDir("/");
            var tmp = root;
            for (var i=1; i<parts.length; i++) {
                var dir = singleDir(parts[i]);
                tmp.addChild(dir);
                tmp = dir;
            }

            return root;
        }

        public int getSize() {
            return getSizeWithRoot() - 1;
        }

        private int getSizeWithRoot() {
            int size = 1;
            for (Directory child : children) {
                size += child.getSizeWithRoot();
            }
            return size;
        }

        private static Directory singleDir(String name) {
            return new Directory(name, new ArrayList<>());
        }
    }

    public Directory findLeastCommonAncestor(String firstPath, String secondPath) {
        var first = Directory.fromPath(firstPath);
        var second = Directory.fromPath(secondPath);

        var result = new Directory("/", new ArrayList<>());
        var root = result;

        var minSize = Math.min(first.getSize(), second.getSize());
        for (int i = 0; i < minSize; i++) {
            first = firstChildOf(first);
            second = firstChildOf(second);

            if (hasFork(first, second)) {
                return root;
            }

            var child = new Directory(first.name, new ArrayList<>());
            result.addChild(child);
            result = child;
        }

        return root;
    }

    private static Directory firstChildOf(Directory second) {
        return Optional.ofNullable(second)
                .map(Directory::children)
                .map(List::stream)
                .flatMap(Stream::findFirst)
                .orElse(null);
    }

    private static boolean hasFork(Directory first, Directory second) {
        if (first == null && second == null) {
            return false;
        }

        if (first == null || second == null) {
            return true;
        }

        return Stream.of(first, second)
                .map(Directory::name)
                .distinct()
                .count() > 1;
    }

}
