package com.buggymind.dictionaries;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

    LRUCache<String, String> cache;

    @Before
    public void setup() {
        cache = new LRUCache<>(3);
    }

    @Test
    public void eviction() {
        cache
                .put("1", "1")
                .put("2", "2")
                .put("3", "3")
                .put("4", "4");

        // 1 should have been evicted
        assertThat(cache.get("1"), nullValue());
        assertThat(cache.get("2"), is("2"));
        assertThat(cache.get("3"), is("3"));
        assertThat(cache.get("4"), is("4"));
    }
}