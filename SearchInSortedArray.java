// Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes
//:There was an issue when i did not put "=" while checking left and right side
//:Debugged and understood we need that to not miss target when low or high is on the target itslef

// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // Check if the Left side is sorted
            else if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // Check the right side if the element is present there
            else if (target > nums[mid] && target <= nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}