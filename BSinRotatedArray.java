//Searching a rotated array
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Implemented based on yesterday's class

class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){//left sorted
                if(nums[low] <= target && nums[mid] > target){ //if num lies in left side
                    high = mid -1;
                
                }else{
                    low = mid +1;
                }
            }
            else {//right sorted
                if(nums[mid] < target && nums[high] >= target){ // if num lies in right side
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
        
    }
}