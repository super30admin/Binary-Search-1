// Time Complexity : O(log n)
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        // System.out.println(low + " " + high);
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid] <= nums[high]){
                if(target> nums[mid] && target <= nums[high]){
                    low= mid+1;
                }
                else{
                    high = mid-1;
                }
                
            }
            if(nums[mid] >= nums[low]){ 
                if(target < nums[mid] && target >= nums[low]){
                    high = mid-1;   
                }
                else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
