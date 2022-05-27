// Time Complexity : O(logmn) where log n is no. of steps taken to find the range m and logm is the operations for doing binary search in target range of size m
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Search in a Sorted Array of Unknown Size

public class Search {
    
        public int search(ArrayReader reader, int target) {
            int low = 0;
            int high = 1;
            
            while(reader.get(high)<target){ //finding the range in which target is at
                //if(target>= reader.get(low) && target <= reader.get(high)) break;
                low = high;
                high = high *2;
            }
            
            while(low<=high){ //doing binary search in that range
                int mid = low + (high-low)/2;
                if(target<reader.get(mid)) high = mid-1;
                else if(target> reader.get(mid)) low = mid+1;
                else return mid;
            }
            return -1;
        }
    
}
