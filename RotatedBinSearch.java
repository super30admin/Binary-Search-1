// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : if conditions



class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[low] <= nums[mid]){ // array is sorted till mid (no rotated elements before mid)
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else { // array rotated before mid element 
                if (target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }            
        } return -1;
    }
}
