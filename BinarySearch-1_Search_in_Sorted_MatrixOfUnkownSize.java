Time Complexity - O(logn)
Space Complexity - O(n)
import java.util.*;

class Solution {
    public int search(ArrayReader reader, int target){
    if (reader.get(0) == target) return 0;

   
    int left = 0, right = 1;
    while (reader.get(right) < target) {
      left = right;
      right <<= 1;
    }

   
    
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (reader.get(mid) == target) return mid;
      if (reader.get(mid) > target) right = mid - 1;
      else left = mid + 1;
    }


    return -1;
  }
}