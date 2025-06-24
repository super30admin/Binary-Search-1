// Time complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // Increasing the range exponentially until reader.get(high) >= target
        while (reader.get(high) < target){
            low = high;
            high = high * 2;
        }
        if (reader.get(high) == target){
            return high;
        }

        // Using binary search within the found range
        return binarySearch(low, high, reader, target);
    }

    private int binarySearch(int low, int high, ArrayReader reader, int target){
        while (low <= high){
            int mid = low + (high - low) / 2; // To prevent Integer Overflow
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target > reader.get(mid)){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

        }
        return -1; // Target not found
    }
}