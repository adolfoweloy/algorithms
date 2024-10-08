package com.adolfoeloy.datastructure.heap.application;

import java.util.PriorityQueue;

/**
 * This problem is an interesting one. It requires A LOT of attention.
 * It's easier to rush into ideas that can trap you in the wrong direction. Some examples:
 * - While defining the sorting logic for the binary heap used to keep track of k weakest rows
 * - Optimising the count finding from rows using a binary search or linear search
 * - The logic to return the list of weakest rows sorted from the weakest to the strongest
 */
public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        // build the priority queue that tracks the row indexes
        // the logic here was specified in https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
        // the thing that is counterintuitive here is that given by the problem's name, I actually have to use a max heap.
        // the reason for that is because the greater elements will be ready to be removed at the top as soon as the
        // queue reaches its k size limit. That way, I can keep the k weakest rows in the heap.
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((i, j) -> {
            if (i.count == j.count) return j.index - i.index;
            else return j.count - i.count;
        });

        for (int i = 0;  i < mat.length; i++) {
            int count = binarySearch(mat[i]);
            Pair entry = new Pair(i, count);

            maxHeap.add(entry);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // collect the k weakest rows indexes
        // sorted from weakest to strongest

        // notice that this solution is tempting, however, the comparison must take into account the
        // same logic added for the comparator provided for the max heap to determine the strongest row.
        // but now, the problem asks to sort the result from weakest to strongest.
//        return maxHeap.stream()
//                .sorted(Comparator.comparingInt(p -> p.count))
//                .map(p -> p.index)
//                .mapToInt(Integer::intValue)
//                .toArray();

        // best way out is to fill out an array from end to beginning with elements polled from the queue
        int[] result = new int[k];
        k = k - 1;
        while (k >= 0) {
            if (maxHeap.isEmpty()) return result;
            result[k] = maxHeap.poll().index;
            k--;
        }

        return result;
    }

    // I could have used an array but that is less legible.
    private static class Pair {
        final int index;
        final int count;

        private Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    // using binary search to find the first position of 0
    // by returning low, I get exactly the count of soldiers (1s)
    private int binarySearch(int[] row) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
