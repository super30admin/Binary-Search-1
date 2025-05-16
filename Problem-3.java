/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Time complexity - O(log n);
// Space complexity - O(1);
// Did you face any issue while solving - No
// exected on leetCode - yes

// Initially assumising high to 1 and checking if target is in between low and high, If not doubling the high;
// In this way, we are finding the interval where our target lies
// Later doing binary search on the subarray, with assuming mid and moving either to left or right half of the mid, rejected 1/2 array every time
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(target > reader.get(high)) {
            low = high;
            high = 2 * high;
        }

        while(low<=high) {
            int mid = low + (high -low)/2;
            if( reader.get(mid) == target) return mid;
            if( target < reader.get(mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
