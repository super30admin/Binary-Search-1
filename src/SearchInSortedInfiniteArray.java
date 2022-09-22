// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Did not run it on the leetcode
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
"/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    int l = 0;
    int r = -1;
    public int search(ArrayReader reader, int target) {
        
        if(reader.get(0) == target) {
            return 0;
        }
        
       int cnt = 1;
       boolean keepMoving = true;
       
       // find upper bound(r) for b search by increasing range by 2 
       while(keepMoving) {
           int num = reader.get(cnt);
           if(num == target) {
               return cnt;
           }
           
           // when num more than target found, that will be r
           if(num > target) {
               r = cnt;
               keepMoving = false;
           }   
           cnt = cnt * 2;
       } 
        
      //run binary search on array between l and r  
      while(l <= r) {
          int mid = l + (r - l) / 2;
          int midNum = reader.get(mid);
          
          if(midNum == target) {
              return mid;
          }
          
          if(midNum < target) {
              l = mid + 1;
          } else {
              r = mid - 1;
          }
      }
        
        return -1;
    }
}
