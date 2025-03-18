// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/*
Since the array is sorted, we can use binary search, but we dont know the length
Hence we identify possible range by assigning right ptr to left and incrementing right * 2
Once we range is identified
We implement binary search

* */


public class SearchInUnknownArray {

    public int search(ArrayReader reader, int target) {
        int left=0;
        int right = 1;
        while(reader.get(right)<target)
        {
            left=right;
            right=right * 2;
        }

        while(left<=right)
        {
            int mid=left + (right - left)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid) > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }
}

interface ArrayReader {

      public  int get(int index);

  }
