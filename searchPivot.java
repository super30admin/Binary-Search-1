// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : 124/196 test cases passed
// Any problem you faced while coding this : different edge cases were not passing because logic is flawed
class Solution {
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int m = l+(r-l)/2;
            if(nums[m] == target) return m;
            if(nums[m] < nums[r]) {
                if(nums[m]<target && target<=nums[r]) l = m+1;
                else r = m-1;
            }
            else if(nums[m] > nums[r]) {
                if(nums[l]<=target && target<nums[m]) r = m-1;
                else l = m+1;
            }
            else return -1;
        }
        return -1;
    }
}