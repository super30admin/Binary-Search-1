// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
I perform binary search on the rotated sorted array to half the search space at each pass. I check if the middle element = target, 
if so I return the index. Else, if the array is left sorted and the target lies in the sorted portion, I set high = mid - 1 and focus on
that portion of the array or I set low = mid + 1. Similarly if array is right sorted and target lies in the sorted portion, I set low = 
mid + 1 and focus on that part or I set high = mid - 1.
*/

public class Solution
{
    public int Search(int[] nums, int target)
    {
        int low = 0, high = nums.Length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }

            //left sorted array
            else if (nums[low] <= nums[mid])
            {
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
            else
            {
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