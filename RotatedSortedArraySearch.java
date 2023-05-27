// Time Complexity : O(log(n)) we're reducing the search space into half during each iteration
// Space Complexity : O(1), no auxiliary data storage needed
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class RotatedSortedArraySearch
{
    public int search(int[] nums, int target)
    {
        int targetIndex = -1;
        if(nums.length == 1 && nums[0] == target)
        {
            return 0;
        }

        int low = 0;
        int high = nums.length -1;

        while(low <= high)
        {
            int mid = low + (high -low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[high] > nums[mid])
            {
                //that means the right side is sorted
                if(nums[mid] < target && target <= nums[high])
                {
                    //search in the right half
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            else
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    //search in the left half
                    high = mid-1;
                }
                else
                {
                    low = mid +1;
                }
            }
        }

        return targetIndex;
    }
}