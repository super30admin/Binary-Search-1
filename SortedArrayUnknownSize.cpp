// Time Complexity - It is O(logn) since we are finding the target using the Binary Search and in one pass.
// T.C. for finding the range is also log(n) since we are doing 2x at every iteration.
// Space Complexity - It is O(n) since the search depends on the number of elements in the array?
// Problems faced - No!
// It runs on Leetcode!
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int high = 1;
        int mid;
        
        // find the range in which my target value lies.
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        
        //apply a binary search on my range
        while(low <= high){
            mid = low + (high - low)/2;
            if(reader.get(mid) == target)
                return mid;
            if(reader.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
    }
};
