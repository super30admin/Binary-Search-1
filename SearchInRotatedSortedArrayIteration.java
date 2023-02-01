// TC: O(logn)
// SC: O(1)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                return m;
            }
            // left is sorted
            if(nums[l] <= nums[m]) {
                if(target >= nums[l] && target <= nums[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if(target >= nums[m] && target <= nums[r]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}