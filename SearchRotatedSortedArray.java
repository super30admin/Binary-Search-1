/*
*Leet Code 33
*/
class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        
        int mid = low+(high-low)/2;
        
        while(low<=high)
        {
            mid = low+(high-low)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            //pivot is in left half
            if(nums[mid] >= nums[low]){
                // search in sorted half
                if(target < nums[mid] && target >= nums[low])
                {
                    high=mid-1;
                }
                // search in un-sorted half
                else
                {
                    low = mid+1;
                }
            }
            //pivot is in right half
            if(nums[mid] <= nums[high])
            {
                // search in sorted half
                if(target <= nums[high] && target > nums[mid])
                {
                    low=mid+1;
                }
                // search in un-sorted half
                else
                {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}