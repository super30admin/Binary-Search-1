
class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        int mid;
        while (low <= high)
        {
            mid = low + (high-low)/2;

            if (nums[mid] == target)
            {
                return mid;
            }

            //right arr sorted
            if(nums[mid] <= nums[high])
            {
                if (nums[mid] < target&& target <= nums[high])
                {
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }

            else
            {
                // left arr is sorted
                if(nums[low]<=target && target <=nums[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}