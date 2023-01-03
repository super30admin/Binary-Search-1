// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        if (nums.size() == 0)
            return -1;
        int low = 0, high = nums.size() - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            // left side is sorted
            else if (nums[low] <= nums[mid])
            {
                // target lies in the left sorted side
                if (nums[low] <= target && nums[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // right side is sorted
            else
            {
                // target lies in the right sorted side
                if (nums[mid] < target && nums[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
                ;
            }
        }
        return -1;
    }
};