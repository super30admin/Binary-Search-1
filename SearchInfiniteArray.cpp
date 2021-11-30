// Time Complexity : Log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Use binary search.
 * 
 * To find higher bound of array keep multiplying high by two till we reach to a point where higher bound is greater than or equal to target.
 * And before updating high make new low set to old high. 
 * After getting higher bound of array, apply binary search using current low and high.
 *
 */

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
        
        while (reader.get(high) < target)
        {
            low = high + 1;
            high *= 2; 
        }
        
        while (low <= high)
        {
            mid = low + (high - low)/2;
            
            if (reader.get(mid) == target)
                return mid;
            
            if (reader.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
};