/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Problem: Search in a Sorted Array of Unknown Size
// The approach uses two phases:
// 1. Range Finding: Since the size is unknown, we exponentially increase the 'high' pointer
//    (doubling it) until we find a range [low, high] that could contain the target.
// 2. Binary Search: Once the range is identified, perform a standard binary search.
//
// Time Complexity: O(log n) where n is the index of the target element.
//                  The range finding takes O(log n) steps, and binary search takes O(log n).
// Space Complexity: O(1) as we only use pointers.

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        // find the high pointer

        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }

        // Normal binary search to find the target
        while(low<=high){
            int mid = low + (high - low)/2 ; // to avoid interger overflow
            if(reader.get(mid) == target){
                return mid;     // we found the target
            }
            if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        // we didn't find the target
        return -1;
    }
}