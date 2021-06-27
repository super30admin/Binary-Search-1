class Solution {
    public int search(int[] nums, int target) {
        
        // TC - O(logn) since we are performing the standard Binary search
        if(nums == null || nums.length == 0)
           return -1;
        int low =0, high = nums.length - 1;
        while(low <=high)
        {
            int mid = low + (high-low)/2;
            
            if(nums[mid]== target)
                return mid;
            
            // left side is sorted
            if(nums[low]<= nums[mid])
            {
                // target is present on sorted side
                if(nums[low] <=target && nums[mid] > target)
                {
                    high = mid-1;
                }
                else
                    // present on unsorted side
                    low = mid+1;
                    
            }
            
            // check whether right side is sorted
            
            else if(nums[mid] <= nums[high])
            {
                if(nums[mid] < target && nums[high] >=target)
                {
                    low = mid+1;
                }
                else
                    high = mid-1;
            }
        }
        return -1;
        
    }
}