package com.adolfoeloy.datastructure.heap.application;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKMostFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // compute frequency O(N)
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int key : nums) {
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        }

        // build the heap O(N log(k)) where k is the number of keys
        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2) -> frequency.get(k2) - frequency.get(k1));
        pq.addAll(frequency.keySet());

        // build the response (O(k log k)) where k here is associated with the variable k
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            if (pq.isEmpty()) break;
            result[i] = pq.poll(); // O(log k)
        }

        // O(N log(k))
        return result;
    }

}
