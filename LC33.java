// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create pointers low and high and calculate mid
//check if the left side is sorted or the right side at this point.
//if the left side is sorted, check if the target value lies in that window. If not, move the low pointer to mid+1.
// same for the right side
// return the mid element if target is found
// else return -1 if while loop exits without finding the target value.

class Solution {
    public int search(int[] nums, int target) {
        //1
        int low = 0;
        int high = nums.length - 1;
        
        //2
        while(low <= high){
            int mid = low + (high - low)/2;
            
            //3
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }
            }
        }
        //4
        return -1;
    }
}