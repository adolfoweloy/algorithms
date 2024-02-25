package com.adolfoeloy.datastructure.heap;

/**
 * For the purposes of practicing, I don't want to create a full-fledged generic heap,
 * so a heap for integers is more than enough here.
 */
public interface IntHeap {

    /**
     * Adds an element in time complexity of O(log N).
     * @param value integer to be added
     */
    void add(int value);

    /**
     * Remove and returns the top element of the heap.
     * Time complexity of O(log N)
     * @return the top element
     */
    int poll();

    /**
     * Returns the value of the top element without removing it from the heap.
     * Time complexity of O(1)
     * @see IntHeap#poll()
     * @return the top element
     */
    int peek();

    /**
     * The size of the heap.
     * @return number of elements in the heap
     */
    int size();

    /**
     * Added for testing purposes to sneak peek into the internal structure of this heap.
     * This allows for an easy way to check if the heap was created correctly in my unit tests.
     *
     * @return the internal array used to maintain the heap.
     */
    int[] asArray();

}
