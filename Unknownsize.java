// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//Time Complexity: O(n)
//Space Complexity: O(1)

// Your code here along with comments explaining your approach
import java.util.*;

class Solution{
  public int search(ArrayReader reader, int target){
    int low = 0;
    int high = 1;
    while(reader.get(high)<target){
      low=high;
      high = 2*high;
    }
    while(low <= high){
      int mid = low + (high - low)/2;
      int temp = reader.get(mid);
      if(temp == target)
        return mid;
      else if(temp > target)
        high = mid - 1;
      else
        low = mid+1;
    }
    return -1;
  }
}
