// Time Complexity : O(Log t) Where t is the index of target value
// Space Complexity : O(1)- Since the search is in place
// Did this code successfully run on Leetcode : yes but i have to see the solution in leetcode to understand this problem.
// Any problem you faced while coding this : Undertsanding the ArrayReader was new to me.  


// Your code here along with comments explaining your approach
class BinarySearchInfiniteArray {
    public int search(ArrayReader reader, int target) {
      if (reader.get(0) == target) return 0;
  
      // search boundaries
      int left = 0, right = 1;
      while (reader.get(right) < target) {
        left = right;
        right <<= 1;
      }
  
     // binary search
    int pivot, num;
    while (left <= right) {
      pivot = left + ((right - left) >> 1);
      num = reader.get(pivot);

      if (num == target) return pivot;
      if (num > target) right = pivot - 1;
      else left = pivot + 1;
    }

    // there is no target element
    return -1;
      
    }
   
  }