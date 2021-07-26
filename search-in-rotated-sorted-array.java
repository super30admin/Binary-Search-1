// Time Complexity: O(log n), where n is the #elements in the array
// Space Complexity: O(1), did not use any auxillary data structure
//Running on leetcode: yes
class Solution
{
    public int search(int[] nums, int target)
    {
        //check if the array is valid
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        //assign low and high pointers
        int low = 0;
        int high = nums.length-1;
        while (low <= high)
        {
            //find the mid of the array
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
            {
                return mid;
            }
            //which side of the array is sorted after ts sorted
            //if left is sorted (code fails if we dont check for sorted part of array ex [5,1,3])
            if (nums[low] <= nums[mid])
            {
                //check if target will lie in the left part
                if (target >= nums[low] && target < nums[mid])
                {
                    high = mid-1;
                }
                else //target lies in the right part
                {
                    low = mid+1;
                }
            }
            else   //right portion is sorted if (nums[high] >= nums[mid])
            {
                //check if target is in the right portion
                if (target <= nums[high] && target > nums[mid])
                {
                    low = mid+1;
                }
                else //target lies in the right part
                {
                    high = mid-1;
                }
            }
        }
        //out of while loop, target not found
        return -1;
    }
}
