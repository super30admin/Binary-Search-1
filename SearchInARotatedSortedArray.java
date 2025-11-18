// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes - forgot to put check for left sorted
// that is - nums[left] <= nums[mid]


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right)
        {
            mid = left + (right - left)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            if(nums[left] <= nums[mid]) // left sorted array
            {
                if(nums[left] <= target && target < nums[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else // right sorted array
            {
                if(nums[mid] < target && target <= nums[right])
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}