// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Problem2 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 1)
        {
            if(nums[0] == target) return 0;
            else return -1;
        }
        while(low <= high)
        {
            int mid = low + ((high-low) / 2);
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
            else {
                if (target <= nums[high] && target > nums[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}