// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// The array is a rotated sorted array, so at least one half is always sorted in each iteration.
// We identify the sorted half and check whether the target lies within that range to decide which side to discard.
// By reducing the search space by half each time, we achieve logarithmic time complexity using constant space.
class Solution
{
    public int Search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.Length - 1;
        int mid = 0;
        while (left <= right)
        {
            mid = (left + right) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            if (nums[left] <= nums[mid])
            {
                if (nums[left] <= target && target < nums[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else
            {
                if (nums[mid] < target && target <= nums[right])
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


