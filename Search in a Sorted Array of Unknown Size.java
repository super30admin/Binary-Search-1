/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
class Solution {
    //Time O(logN)
    //Space O(1)
/*
   we can double the size of the array until we find a invalid element from there we can apply binary search   
*/
    public int search(ArrayReader reader, int target) {
      int low = 0 , high = 1;
      while(reader.get(high) != Integer.MAX_VALUE)
      {
          high = high*2;
      }
      while(low <= high)
      {
          int mid = low + (high-low)/2;
          if(reader.get(mid) == Integer.MAX_VALUE)
          {
              high = mid-1;
          }
          if(reader.get(mid) == target)
          {
              return mid;
          }
          if(reader.get(mid) < target)
          {
              low = mid+1;
          }
          else
          {
              high = mid-1;
          }
      }
        return -1;
    }
}