package com.adolfoeloy.disjointset;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnionFindUnionFindTest {

    @Test
    void connected__should_return_false_when_two_components_are_not_connected() {
        QuickUnion uf = new QuickUnion(10);
        assertThat(uf.isConnected(1, 5)).isFalse();
    }

    @Test
    void union__should_connect_two_components() {
        QuickUnion uf = new QuickUnion(10);
        uf.union(1, 5);
        assertThat(uf.isConnected(1, 5)).isTrue();
    }

    @Test
    void union_should_connect_two_root_components() {
        QuickUnion uf = new QuickUnion(10);
        // creating first tree
        uf.union(1, 5);
        uf.union(2, 1);
        assertThat(uf.isConnected(2,5)).isTrue();

        // creating the second tree
        uf.union(3, 7);
        uf.union(6,7);
        assertThat(uf.isConnected(3,6)).isTrue();

        assertThat(uf.isConnected(3, 2)).isFalse();
        uf.union(3, 2);
        assertThat(uf.isConnected(3, 2)).isTrue();
    }
}