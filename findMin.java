// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n-1;

        while(l <= h){
            if(nums[l] <= nums[h]){
                return nums[l];
            }

            int mid = l + (h - l) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n-1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[l] <= nums[mid]){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        return -1;
    }
}