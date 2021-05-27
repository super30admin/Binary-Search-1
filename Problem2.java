class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0; int right = nums.length-1;
        
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            int midval = nums[mid];
            
            if(midval ==  target)
            {
                return mid;
            }
            else if(nums[left] > nums[mid])     // if left to mid is unsorted subarray
            {
                if(midval < target && target <= nums[right])     // must be sorted subarray. Is the target value with in the range.
                {
                    left = mid+1;
                }
                else
                {
                    right = mid-1;
                }
            }
            else  // left -> mid must be sorted
            {
                if(target < midval && target >= nums[left])
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }
            }
        }
        
        return -1;
        
    }
}