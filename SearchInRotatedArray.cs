using System;
namespace Algorithms
{
    public class SearchInRotatedArray
    {
        /// Time Complexity : O(lognß)
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No

        public int Search(int[] nums, int target)
        {
            if (nums != null && nums.Length == 0) return -1;
            int start = 0; int end = nums.Length - 1;
            int mid;
            while (start <= end)
            {
                mid = start + (end - start) / 2;
                if (nums[mid] == target) return mid;
                //find which side is sorted
                if (nums[start] <= nums[mid])
                {
                    //left side sorted
                    if (nums[start] <= target && target < nums[mid])
                    {
                        end = mid - 1;
                    }
                    else
                    {
                        start = mid + 1;
                    }
                }
                else
                {
                    //right side sorted
                    if (nums[mid] < target && target <= nums[end])
                    {
                        start = mid + 1;
                    }
                    else
                    {
                        end = mid - 1;
                    }

                }
            }
            return -1;
        }
    }
}
