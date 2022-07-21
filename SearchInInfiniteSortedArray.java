/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1. Since the size is unknown, made an assumption that the size is infinity which in the program's perspective is Integer.MAX_VALUE
//2. Performed binary search on that space to search for target

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int left = 0, right = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int element = reader.get(mid);
            if(element == target) {
                return mid;
            }
            else if(target < element) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}