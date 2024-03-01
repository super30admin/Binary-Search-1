/**

  Thought Process:
  Since we have unknown size, we use 2 pointers, slow and fast and determine the range of l & h where the target should eventually fall
  Say, m is the no of iterations or multiples of 2s untill we find the n size of range i.e target in l -> h.
  Apply Binary Serach on the range and return result.

  Time Complexity -> O(logm + logn) -> where m is the number of 2s multiples untill we find the range and n is the actual range l to h
  and deducing TC for a binary serach
  Sapce Complexity -> O(1)

**/

public class Solution{

  public int search(ArrayReader reader, int target){
    int l = 0, h = 1;

    // Find the range l -> target -> h, in multiples of 2, so O(logm) with base 2. 
    // If multiple was 3 or 5 then base would have been 3 or 5
    while(reader.get(h) <= target){
      l = h;
      h = h * 2;
    }
    while(l <= h){
      int mid = l + (h-l) / 2;
      if(reader.get(mid) == target) return mid;

      if(reader.get(mid) > target)
        h = mid-1;
      else l = mid+1;
    }
    return -1;
  }
}
