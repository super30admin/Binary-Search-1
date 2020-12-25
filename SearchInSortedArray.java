// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        //initialize low and high variable
        int low = 0, high = nums.length - 1;
        while(low <= high){
            //Compute mid
            int mid = low + (high - low) / 2;
            //if we find the target at the mid
            if(nums[mid] == target){
                return mid;
            }
            //if mid element is greater than the low element it is sorted
            else if(nums[mid] >= nums[low]){
                //if target is greater than low or less than mid
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    //increment low
                    low = mid + 1;
                }
            }
            else{
                //target is greater than mid and less than high
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    
    }
}