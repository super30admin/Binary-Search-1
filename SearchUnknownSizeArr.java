// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


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
        int low = 0; int high = 1;
        // increment 2*high to get the low and high pointer
        while(reader.get(high) < target) {
            low = high;
            high = 2*high;
        }
        return binarySearch(reader, target, low,high);
    }
    private :
    
   int binarySearch(const ArrayReader& reader, int target, int low, int high) {
        //binary search to find the target element
        while(low <= high) {
          int mid = low + (high-low) /2;
          if(reader.get(mid) == target) {
              return mid;
          } else if(reader.get(mid) < target) {
              low = mid+1;
          } else {
              high = mid-1;
          }
        }
       return -1;
        
    }
};