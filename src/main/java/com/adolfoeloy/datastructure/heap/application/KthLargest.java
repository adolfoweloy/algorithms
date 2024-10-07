package com.adolfoeloy.datastructure.heap.application;

import java.util.PriorityQueue;

public class KthLargest {

    private final int k;

    // The first thing that may come to mind is to use a max heap
    // However, to retrieve the kth element from a max heap one would need to poll k elements to find the kth
    // and add all of them back to the queue. If the queue has huge size N, that means 2 x n log n for each add operation
    // see add method. If the stream is huge N that means n x 2n log n, which can be simplified to quadratic time.

    // That's why a minHeap is the way to go if implementing with priority queues.
    // With a min heap, I can store k elements and keep only the large elements. Whenever the queue goes above k, I drop the smallest
    // by calling poll, and it turns out that the top entry in the queue will be always the kth element.
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    KthLargest(int k, int[] nums) {
        this.k = k;
        for (Integer n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        // I just add an entry to the heap if len(queue) < k OR val is greater than the top entry in the min heap.
        // the logic here is to just add val if it is greater than top entry in the min queue because we want to keep largest k elements.
        // however, to compare the value without losing it from the heap, I need to call peek.
        // But I can only do that if the heap is not empty. But if I just add if the queue is not empty how would I add the first entry?
        // That's why I shortcut asking for len(heap) < k, which means, if the queue still has less than k elements, I can just
        // keep adding elements and whenever the size goes beyond k, I just drop the smallest entry which again, turns out to be the one at the top.
        if (minHeap.size() < k || val > minHeap.peek()) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll(); // drop the smallest one if size went above the limit
            }
        }

        // at this point the heap contains all largest entries
        // the smaller one (at root level) is the kth element
        return minHeap.peek();
    }
}
