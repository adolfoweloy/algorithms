package com.adolfoeloy.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    @Test
    void shouldGetValuesAddedToTheCache() {
        LRUCache cache = new DefaultLRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        assertThat(cache.get(1)).isEqualTo(10);
        assertThat(cache.get(2)).isEqualTo(20);
        assertThat(cache.get(3)).isEqualTo(30);
        assertThat(cache.get(4)).isEqualTo(-1);
    }

    @Test
    void shouldEvictLessRecentlyUsedEntry() {
        LRUCache cache = new DefaultLRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);

        // gets key number one twice, so key two should be the least recently used
        assertThat(cache.get(1)).isEqualTo(10);
        assertThat(cache.get(1)).isEqualTo(10);

        // when adding key number three, number two should be evicted
        cache.put(3, 30);

        assertThat(cache.size()).isEqualTo(2);

        // two should have been evicted
        // the new key should be there
        assertThat(cache.get(2)).isEqualTo(-1);
        assertThat(cache.get(1)).isEqualTo(10);
        assertThat(cache.get(3)).isEqualTo(30);

        // number one should still continue in the cache since this one is the most used one
        cache.put(4, 40);

        assertThat(cache.size()).isEqualTo(2);
        assertThat(cache.get(1)).isEqualTo(-1);
        assertThat(cache.get(4)).isEqualTo(40);
    }

}