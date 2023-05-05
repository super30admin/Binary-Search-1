/*
 * Time Complexity: 0(log(m))
 * Space Complexity: 0(1)
 */
namespace LeetCodeSubmission.BinarySearch1;

public class SearchInARotatedSortedArray
{
    public int Search(int[] nums, int target) {
        int low = 0;
        int high = nums.Length - 1;

        while (low <= high)
        {
            int mid = (high - low) / 2 + low;
            
            if (nums[mid] == target)
            {
                // return result case
                return mid;
            }
            else
            {
                if (nums[mid] > target)
                {
                    if (nums[low] <= nums[mid] && nums[low] > target)
                    {
                        // sorted lhs; search in unsorted part
                        low = mid + 1;
                    }
                    else
                    {
                        high = mid - 1;
                    }
                }
                else if (nums[mid] < target)
                {
                    if (nums[mid] <= nums[high] && nums[high] < target)
                    {
                        // sorted rhs; search in unsorted part
                        high = mid - 1;
                    }
                    else
                    {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}