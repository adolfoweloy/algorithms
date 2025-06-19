package com.adolfoeloy.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNodeFactoryTest {

    private final TreeNodeFactory subject = new TreeNodeFactory();

    @Test
    void createTreeWithRootAndTwoChildren() {
        var result = subject.create(new Integer[] {1, 2, 3});

        var expected = new TreeNode(
                1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null)
        );

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void createLargeTreeWithNullChildren() {
        var result = subject.create(new Integer[] { 3,5,1,6,2,0,8,null,null,7,4} );

        var expected = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4)
                        )
                ),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)
                )
        );

        assertThat(result).isEqualTo(expected);
    }
}