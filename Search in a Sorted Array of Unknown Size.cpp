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
    // Time Complexity : O(logn)
    // Space Complexity :  O(1)
    // Did this code successfully run on Leetcode :  Yes
    // Any problem you faced while coding this :  No

    /*
    The array size is unknown, but the highest size can be 10^4
    We can just binary search in this range.
    If the mid element falls out of range, we will adjust our right border to mid-1
    */
    int search(const ArrayReader& reader, int target) {
      const int maxn = 10000;
      int lo = 0, hi = 10000;
      

      while(lo<hi){
        int mid = (lo+hi+1)/2;
        int val = reader.get(mid);

        if(val > target || val > maxn)  hi = mid-1;
        else  lo = mid;
      }

      return reader.get(lo) == target ? lo : -1;
    }
};
