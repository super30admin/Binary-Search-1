// Time Complexity : The time complexity is O(log(n)) where n is the length of the Array because to find the window in which target is present
// the end is doubled in every iteration and to find the target the search space is divided by half.
// Space Complexity : The space complexity is O(1) since no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {

        if(reader.get(0) == target) {return 0;}

        int start = 0;
        int end = 1;

        // Finds the window in which the target is present
        while(reader.get(end) < target){
            start = end;
            end = end*2;
        }

        // Perform binary search once we find the window
        while(start <= end){

            int mid = (end-start)/2 + start;

            // Return index if target is found
            if(reader.get(mid) == target){
                return mid;
            }
            // If target is less than mid, move to the left
            else if(target < reader.get(mid)){
                end = mid-1;
            }
            // If target is greater than mid, move to the right
            else{
                start = mid+1;
            }

        }

        return -1;

    }
}