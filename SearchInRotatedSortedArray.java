// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        
		// Initializing left to 0 and right to length of nums - 1 as indexes in array starts from 0
        int l=0, r=nums.length-1;
        
		// Terminating condition
        while(l<=r){
			// calculate mid
            int mid = l + (r-l)/2;
			// if nums[mid] is equal to target, return mid (returns index of the value)
            if(nums[mid] == target){
                return mid;
            }
			
			// nums[l] <= nums[mid] condition tells if left part of mid, array is sorted or the right part
            else if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}