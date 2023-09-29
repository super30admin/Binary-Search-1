public class Solution
    {
        // Time Complexity : O(log n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int Search(int[] nums, int target)
        {
            if (nums == null || nums.Length == 0)
                return -1;

            int low = 0;
            int high = nums.Length - 1;

            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target)
                    return mid;

                //Left sorted array
                else if (nums[low] <= nums[mid])
                {
                    //if target is in the range of low and mid
                    if (nums[low] <= target && target < nums[mid])
                    {
                        high = mid - 1;
                    }
                    else
                    {
                        low = mid + 1;
                    }
                }
                //right sorted array
                else if (nums[mid] < nums[high])
                {
                    //if target is int the range of mid and high
                    if (nums[mid] < target && target <= nums[high])
                    {
                        low = mid + 1;
                    }
                    else
                    {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }

    }
