// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */


// Initially, start with 2 elements and if the target is greater than the element at 'r', double the value of 'r'. Else, do binary search in the range l to r.
class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 1;
        
        while ( l <= r)
        {
          if ( target > reader.get(r))
          {
            l = r;
            r = r * 2;
          }
          else
          {
            int mid = l + (r-l)/2;
            if ( reader.get(mid) == target)
                return mid;
            else if (target < reader.get(mid))
                r = mid - 1;
            else
                l = mid+1;
          }
        }
        return -1;
    }
}
