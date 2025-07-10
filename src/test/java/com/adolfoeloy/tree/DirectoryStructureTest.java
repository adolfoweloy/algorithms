package com.adolfoeloy.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.adolfoeloy.tree.DirectoryStructure.Directory.fromPath;
import static org.assertj.core.api.Assertions.assertThat;

class DirectoryStructureTest {

    @Nested
    class DirectoryTestCases {

        @Test
        void fromPath__should_create_a_directory_structure() {
            var directory = fromPath("/a/b/c");

            var expected = new DirectoryStructure.Directory("/", List.of(
                    new DirectoryStructure.Directory("a", List.of(
                            new DirectoryStructure.Directory("b", List.of(
                                    new DirectoryStructure.Directory("c", List.of())
                    ))
            ))));

            assertThat(directory).usingRecursiveComparison().isEqualTo(expected);
        }

        @Test
        void fromPath__should_create_a_directory_structure_for_root() {
            var directory = fromPath("/");

            var expected = new DirectoryStructure.Directory("/", List.of());

            assertThat(directory).usingRecursiveComparison().isEqualTo(expected);
        }

        @Test
        void fromPath__should_throw_illegal_argument_exception_when_path_is_empty() {
            Assertions.assertThatIllegalArgumentException().isThrownBy(() -> fromPath(""))
                    .withMessage("Path cannot be empty");;
        }
    }

    @Nested
    class DirectoryStructureTestCases {
        private final DirectoryStructure subject = new DirectoryStructure();

        @Test
        void findLeastCommonAncestor__should_find_root_as_lca_for_paths_with_different_sizes() {
            var result = subject.findLeastCommonAncestor("/", "/a/b/c/d/e");
            assertThat(result)
                    .usingRecursiveComparison()
                    .isEqualTo(fromPath("/"));
        }

        @Test
        void findLeastCommonAncestor__should_find_b_as_lca() {
            var result = subject.findLeastCommonAncestor("/a/b/c", "/a/b/d");
            assertThat(result)
                    .usingRecursiveComparison()
                    .isEqualTo(fromPath("/a/b"));
        }

        @Test
        void findLeastCommonAncestor__should_find_a_as_lca_for_paths_with_different_sizes() {
            var result = subject.findLeastCommonAncestor("/a/b/c", "/a/b");
            assertThat(result).usingRecursiveComparison().isEqualTo(fromPath("/a/b"));
        }

        @Test
        void findLeastCommonAncestor__should_find_lca() {
            var result = subject.findLeastCommonAncestor("/a/b/c/d", "/a/b/c/e");
            assertThat(result)
                    .usingRecursiveComparison()
                    .isEqualTo(fromPath("/a/b/c"));
        }
    }

}