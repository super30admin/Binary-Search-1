// 702. Search in a Sorted Array of Unknown Size
import java.util.*;

class Problem3{
    public int search(ArrayReader reader, int target){
        int low=0;
        int high=1;// To be able to multiply twice everytime
        while(reader.get(high)<target){
            low=high;
            high=high*2;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid) >target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;// If Value is not Present
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (Could not try since LC premium Question but ran on multiple example values)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// 1. First I set the Low and HIgh pointer to 0 and 1 respectively and kep increasing the higher twice until its bigger than Mid.
// 2. After getting a range I could Apply the normal binary search 