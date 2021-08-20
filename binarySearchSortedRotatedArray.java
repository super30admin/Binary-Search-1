// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        
        int start = 0, end = nums.length -1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < nums[start]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid +1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] <= target && nums[mid] > target){
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
}