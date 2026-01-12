// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
// double the high index until the target is within range

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        // Expand the search window until the target is within range
        while(reader.get(high) < target){ 
            low = high ;
            high = high * 2;
        }

        // Perform binary search within the identified window
        while(low <= high){ 
            int mid = low + (high - low)/2;
            // If target is found, return its index
            if(reader.get(mid) == target) return mid;
            // If mid value is greater than target, search left half
            if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                // If mid value is less than target, search right half
                low = mid + 1;
            }
        }
      
        // Target not found
        return -1;
    }
}