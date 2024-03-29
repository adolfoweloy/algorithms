package com.adolfoeloy.disjointset;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickFindTest {

    @Test
    void should_connect_two_elements() {
        UnionFind unionFind = new QuickFind(5);

        unionFind.union(0, 1);

        assertThat(unionFind.isConnected(0, 1)).isTrue();
    }

    @Test
    void isConnected_should_return_false_if_two_elements_are_not_connected() {
        UnionFind unionFind = new QuickFind(5);

        unionFind.union(0, 1);

        assertThat(unionFind.isConnected(0, 3)).isFalse();
    }

    @Test
    void should_connect_two_trees() {
        UnionFind UnionFind = new QuickFind(5);

        UnionFind.union(0, 1);
        UnionFind.union(3, 4);

        assertThat(UnionFind.isConnected(0, 1)).isTrue();
        assertThat(UnionFind.isConnected(3, 4)).isTrue();
        assertThat(UnionFind.isConnected(1, 3)).isFalse();
    }
}