// Time Complexity : O(logn + logm)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 // This is ArrayReader's API interface.
 // You should not implement it, or speculate about its implementation
  interface ArrayReader {
     public int get(int index);
     
 }
 
public class ArrayReaderSolution {
    
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        int mid =0;
        while(reader.get(high) < target)
        {
            low = high;
            high = 2*high;
        }
        while (low <= high)
        {

            mid = low + (high - low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
            {
             high = mid -1;   
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
}
