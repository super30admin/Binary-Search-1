/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
// Time Complexity
// With bruteforce solution: O(n)
// With Binary search Optimization: O(Log n)
// Where n = number of elements in array.
// Space Complexity
// With bruteforce solution: O(1)
// With Binary search Optimization: O(1)

class Solution {
    public int search(ArrayReader reader, int target) { // As we don't know our high pointer. Let's consider it as 1
        int low = 0; // first index of array
        int high = 1;// Second index of array
        while (reader.get(high) < target) {
            low = high; // Set low to high
            high = 2 * high; // Set high to 2 times high. This to increase the search space two times for
                             // binary search
        }
        while (low <= high) { // Loop until low becomes greater than high
            int mid = low + (high - low) / 2; // Mid point of the array
            if (target == reader.get(mid)) { // If target is found at mid return the index
                return mid;
            } else if (reader.get(mid) > target) { // If target is smaller than integer at mid,
                high = mid - 1; // move high pointer to index before mid
            } else { // If target is greater than integer at mid,
                low = mid + 1; // move low pointer to index after mid
            }
        }
        return -1;
    }
}