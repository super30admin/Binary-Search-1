
public class Solution {
  public int search(ArrayReader reader , int target)
  {
      int low =0;
      int high =1;
      // We are moving high by multiplying by 2 to achieve logarithmic time.

      while(reader.get(high)<=target)
      {
        low = high;
        high = high*2;
      }
      // Time Complexity : O(log(high-low)) which is size of the array traversed
      return binarySearch(reader, target, low, high);
  }

  private int binarySearch(ArrayReader reader , int target, int low , int high)
  {
    while(low<=high)
    {
      int mid = low+(high-low)/2; // Prevent Integer overflow exception
      if(reader.get(mid)==target)
      {
        return mid; // if target and mid are equal
      }
      else if (reader.get(mid)<target)
      {
        low = mid+1; // if target is greater than element at mid
      }
      else {
        high = mid -1; // if target is less than element at mid
      }
    }
    return -1; // Element not found
  }
}
