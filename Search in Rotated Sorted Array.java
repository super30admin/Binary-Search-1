// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/search-in-rotated-sorted-array/
// Any problem you faced while coding this :


class Solution {
    public int search(int[] nums, int target) {
        int left =0, right = nums.length-1;
	        while(left<=right){
	            int mid=left+(right-left)/2;

	            if(nums[mid]==target) return mid;
	            
	            if (nums[left] <= nums[mid]) {
	            if(target>=nums[left]&&target<nums[mid]){
	                right = mid-1;
	            }else{
	                left = mid+1;
	            }
	            }else {
	            if(target<nums[mid] && target<=nums[right]){
	                left=mid+1;
	            }else{
	                right = mid-1;
	            }
	         }
	        }
	        return -1;
    }
}
