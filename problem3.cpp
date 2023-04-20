// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// as we dont know the size, we start with lo =0 and hi = 1,
//  we keep on multiplying hi = hi * 2 untill the value at index hi is less than target, and update lo as well.
//  After that we do binary search.





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
        int lo = 0, hi = 1;
        while(reader.get(hi)< target)
        {
            lo = hi;
            hi = hi * 2;
        }
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(reader.get(mid)==target) return mid;
            else if ( target < reader.get(mid))
            {
                hi = mid - 1;
            }
            else 
            {
                lo = mid + 1;
            }
        }
        return -1;
        
    }
};