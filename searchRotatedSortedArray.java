class Solution {
    public int search(int[] nums, int target) {
        //base case
        if(nums == null || nums.length==0)
        {
            return -1;
        }
        
        int low = 0;
        int high = nums.length-1;
        
        int mid = 0;
        
        while(low<=high)
        {
            mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid]<=nums[high])
            {
                if(target>nums[mid] && target<=nums[high])
                {
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
             else if(nums[mid]>=nums[low])
            {
                if(target>=nums[low] && target<nums[mid])
                {
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
        
    }
    
}
//runtime: Since we are using binary search it is O(logn) and O(1) for the rest of the lines and fuctions
//space complexity: since we are not using any additional space it is O(1)
