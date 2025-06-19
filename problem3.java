// Time Complexity : O(log(idx)) where idx is the index of the target in the array
// Space Complexity : O(1) as nothing extra is created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I first set the upper bound of the search space to 1 and keep doubling it until the value at that index is greater than or equal to the target.
// Then I perform a binary search between the lower bound and the upper bound to find the target.
// I also update low to the last high value before the loop breaks, so that we can search in a smaller range.

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        int low = 0;
        while(reader.get(high) < target){
            low = high;
            high *= 2;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid)<target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}