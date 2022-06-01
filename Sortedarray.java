// Time Complexity : o(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        //initializing the low and high pointers
        int low=0;
        int high = 1;
        
        while(reader.get(high) < target){
            //using high as a fast pointer and then comparing it with target
            low=high;
            high=2*high;
        }
        
        while(low<=high){
            int mid = low + (high-low)/2; //finding mid
            if(reader.get(mid) == target) //comparing mid with target
                return mid;
            else if(reader.get(mid) > target) //if greater than change high pointer
                high =mid-1;
            else
                low = mid + 1; //else change low pointer
        }
        
        return -1;
    }
}