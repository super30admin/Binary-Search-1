// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int search(int[] nums, int target) 
    {
        int n = nums.length;
        int low = 0, high = n-1;
        int indexOfSmallestNumber = 0;
        //Finding the smallest number
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (nums[mid]==target)
            {
                return mid;
            }
            else if (nums[mid]<nums[0])
            {
                if (nums[mid-1]>nums[mid])
                {
                    indexOfSmallestNumber = mid;
                    break;
                }
                else
                {
                    high = mid-1;
                }
            }
            else
            {
                low = mid+1;
            }
        }
        //perform binary search on all the elements on the left of the smallest number and on the right of it.
        int b1 = binarySearch(nums, 0, indexOfSmallestNumber-1, target);
        int b2 = binarySearch(nums, indexOfSmallestNumber, n-1, target);
        if (b1!=-1)
        {
            return b1;
        }
        else if (b2!=-1)
        {
            return b2;
        }
        else
        {
            return -1;
        }
    }

    private int binarySearch(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (nums[mid]==target)
            {
                return mid;
            }
            else if (nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
}
