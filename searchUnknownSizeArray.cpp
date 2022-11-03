// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


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
        
        // starting with the smallest window 
        // for an array of size 1, reader.get(1) = infinity
        int low = 0;
        int high = 1;
        
        // run the while loop till we establish the boundaries to later do the binary search 
        while(target > reader.get(high)){ 
            low = high;
            high *= 2;
        }
        
        while(low<=high){
                int mid = low + (high - low)/2; //avoid integer overflow 
                if (reader.get(mid) == target)
                    return mid;
                if(target < reader.get(mid))
                    high = mid-1;
                else 
                    low = mid+1;
            }
        return -1;
    }
};