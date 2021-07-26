using System;
//Time complexity : O(log(n))
//Space Complexity : O(1)
public class RotatedArrayBinarySearch{
    public int Search(int[] nums, int target)
        {
            if (nums == null || nums.Length == 0)
            {
                return -1;
            }
            int low = 0;
            int high = nums.Length - 1;
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target)
                {
                    return mid;
                }
                if (nums[low] <= nums[mid]){ //left portion is sorted
                    if (target >= nums[low] && target < nums[mid])
                    {
                        high = mid - 1;
                    }
                    else { low = mid + 1; }
                }
               else{//right portion is sorted
                if (target > nums[mid] && target <= nums[high])
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