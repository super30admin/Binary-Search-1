public class UnknownSizeArraySearch {
  /*
  https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

  Approach:

    It is given that the Array would be sorted, so we know Binary search can help us and 
    that it is more efficient than linear search.

    To implement Binary search, we require the indexes of the start and element between which the target could lie.
    Since the array is of an unknown length here, we don't know the end limit. So find the end limit within which 
    the target could lie and then perform the normal Binary search.


    Time Complexity: O(log(n))
  
    Space Complexity: O(1)

    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No    
  */
  public int search(ArrayReader reader, int target) {
    int left = 0, right = 1;

    while(reader.get(right) < target){
      left = right;
      right = right * 2; // Doubling the size each time allows us to keep our search still be in logarithmic complexity.
    }

    while(left <= right){
      int mid = left + (right - left) / 2;

      if(reader.get(mid) == target){
        return mid;
      } else if (reader.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
}
