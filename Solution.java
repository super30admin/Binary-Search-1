//search-in-a-sorted-array-of-unknown-size

//Time Complexity:O(logn)
//Space Complexity:O(1)

 // This is ArrayReader's API interface.
  // You should not implement it, or speculate about its implementation
  interface ArrayReader {
      public int get(int index);
  }



//Binary search where size increments by 2
class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        //incremental binary search where size doubles every time

        while(reader.get(high)<target)
        {
            low=high;
            high=high*2;
        }
        //apply regular binary search
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(reader.get(mid)<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}