using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms
{
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Initially when I tried this problem based on the algorithm
    // discussed in the class - Identify the sorted side of an array and search the element on that side
    // I missed to check if the right part of the array is sorted condition.It took a while for me to figure 
    // out the mistake after a couple of failed runs on Leetcode
    class RotatedSortedArraySinglePass
    {
        //Time Complexity - O(log n) - Since in worst case scenario we might be reducing search space on both sides.
        //Space Complexity - O(1) - Since we are not using any additional space
        public int Search(int[] nums, int target)
        {

            if (nums == null || nums.Length == 0)
            {
                return -1;
            }
            var left = 0;
            var right = nums.Length - 1;

            while (left <= right)
            {
                var mid = left + (right - left) / 2;
                if (nums[mid] == target)
                {
                    return mid;
                }
                else if (nums[left] <= nums[mid])
                { // Is the left part of the array sorted?
                    if (target >= nums[left] && target < nums[mid])
                    { // Is the target in the sorted side of the array
                        right = mid - 1;
                    }
                    else
                    {
                        left = mid + 1;
                    }
                }
                else
                { // Is the right part of the array sorted?
                    if (target <= nums[right] && target > nums[mid])
                    { // Is the target in the sorted side of the array
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
}
