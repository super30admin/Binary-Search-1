// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


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
        int high = findLastIndex(reader);

        while(low <= high) {
            int mid = (low+high)/2; 
            if(reader.get(mid) == target) return mid; 
            if(reader.get(mid) < target) low = mid+1; 
            else high = mid-1; 
        }

        return -1; 
    }

    int findLastIndex(const ArrayReader& reader) {
        int low = 0; 
        int high = 10000; 

        while(low <= high) {
            int mid = (low+high)/2;
            long long midElement = reader.get(mid);
            if(midElement != INT_MAX) {
                if(reader.get(mid+1) == INT_MAX) return mid; 
                low = mid+1; 
            } else {
                high = mid-1;
            }
        }

        return -1; 
    }
};