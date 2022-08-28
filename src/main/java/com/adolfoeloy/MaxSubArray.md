## The problem

To find the sub-array within an array so that the sum of all elements of the 
sub-array is the maximum sum that can be found. The algorithm should
produce only the sum of the max sub-array.

## The solution

A brute-force algorithm can be implemented, however it has `O(N^2)` complexity time.
Fortunately there is a solution that allows the solution to be found
in one go, i.e. iterating the array only once.

The idea is to detect the sub-array that can be discarded when creating a
sub-array while walking through the array. To detect the sub-array to discard
we need to track the sum of the elements as we go and whenever the
sum with the current element is smaller than the current element, that means
that the current sub-array is not worth keeping. So to discard we start the sum
again with the current element and proceed iterating.

For each iteration, keep the max value comparing the current sum with a variable
that keeps track of the max value.

Here is an example:

```java
int maxSubArray(int[] nums) {
    int ans = nums[0]; // answer (keeps track of the max value)
    int a = nums[0];   // sum of the current subarray
    for (int i=1; i<nums.length; i++) {
        if (nums[i] + a < nums[i]) {
            a = nums[i];  // reset to an empty array when the sum is not worth keeping
        } else {
            a += nums[i]; // keep incrementing the array sum (in a greedy way)
        }
        ans = Integer.max(a, ans); // keeping track of the max subarray sum
    }
    return ans;
}
```

The logic comparing the current value with the current sub-array sum can be 
simplified to what follows:

```java
// throw the subarray away in case it's not worth and start a new subarray
a = Integer.max(nums[i], nums[i] + a); 
```
