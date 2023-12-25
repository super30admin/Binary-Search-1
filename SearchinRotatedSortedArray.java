TC = O(logn)
SC = 0(logn)

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1; 
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            else if(nums[mid] >= nums[low])
            {
                if(target >= nums[low] && target < nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }

            }
            else
            {
                if(target > nums[mid] && target <= nums[high])
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