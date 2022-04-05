// Time Complexity : log(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class Solution {
    public int search(int[] nums, int tar) {
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == tar) {
                return mid;
            }
            
            //first half is sorted
            if(nums[low] <= nums[mid]) {
                //check if key lies in first part or not
                if(tar >= nums[low] && tar <= nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(nums[mid] <= tar && tar <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        
        
        return -1;
    }
}