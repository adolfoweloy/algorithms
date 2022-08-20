package com.adolfoeloy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class FileSystemTest {
    private FileSystem fs;

    @BeforeEach
    void setUp() {
        fs = new FileSystem();
    }

    @Test
    @DisplayName("should create directories")
    void mkdir() {
        fs.mkdir("/usr/local");
        fs.mkdir("/usr/lib");
        fs.mkdir("/usr/library/files");
    }

    @Test
    @DisplayName("should return list of subdirectories of a dir")
    void ls_dirs_test() {
        fs.mkdir("/usr/local");
        fs.mkdir("/usr/lib");
        fs.mkdir("/usr/library/files");

        List<String> ls = fs.ls("/usr");

        assertThat(ls).containsExactly( "lib", "library", "local");
    }

    @Test
    @DisplayName("should return list of subdirectories of a dir")
    void ls_a() {
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");

        List<String> ls = fs.ls("/");

        assertThat(ls).containsExactly( "a");
    }

    @Test
    @DisplayName("should return subdirectories only for directory in between")
    void ls_mkdir_ls() {
        assertThat(fs.ls("/")).isEqualTo(emptyList());
        fs.mkdir("/a/b/c");
        assertThat(fs.ls("/a/b")).containsExactly("c");
    }

    @Test
    @DisplayName("should return list of subdirectories and files of a dir")
    void ls_with_files_test() {
        fs.mkdir("/usr/local");
        fs.mkdir("/usr/lib");
        fs.addContentToFile("/usr/example", "this is a content");
        fs.addContentToFile("/usr/local/another", "another file with content");

        List<String> ls = fs.ls("/usr");

        assertThat(ls).containsExactly( "example", "lib", "local");
    }

    @Test
    @DisplayName("addContentToFile should create file with content")
    void addContentToFile() {
        fs.mkdir("/usr/local");
        fs.mkdir("/usr/lib");
        fs.addContentToFile("/usr/example", "this is a content");
        fs.addContentToFile("/usr/local/another", "another file with content");

        assertThat(fs.readContentFromFile("/usr/example")).isEqualTo("this is a content");
        assertThat(fs.readContentFromFile("/usr/local/another")).isEqualTo("another file with content");
        assertThat(fs.readContentFromFile("/usr/local/invalid")).isNull();
        assertThat(fs.readContentFromFile("/uar/lib")).isNull();
    }

    @Test
    void test_ls_with_files() {
        fs.mkdir("/goowmfn");
        assertThat(fs.ls("/goowmfn")).isEqualTo(emptyList());
        assertThat(fs.ls("/")).containsExactly("goowmfn");
        fs.mkdir("/z");
        assertThat(fs.ls("/")).containsExactly("goowmfn", "z");
        assertThat(fs.ls("/")).containsExactly("goowmfn", "z");
        fs.addContentToFile("/goowmfn/c", "shetopcy");
        assertThat(fs.ls("/z")).isEqualTo(emptyList());
        assertThat(fs.ls("/goowmfn/c")).containsExactly("c");
        assertThat(fs.ls("/goowmfn")).containsExactly("c");
    }

    @Test
    void addContentToFile_append() {
        fs.mkdir("/a/b/c/d");
        fs.addContentToFile("/a/b/e", "hello world");
        fs.addContentToFile("/a/b/e", " folks");

        assertThat(fs.readContentFromFile("/a/b/e")).isEqualTo("hello world folks");
    }
}