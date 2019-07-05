class Solution
{
    public static int search(int[] nums, int target) {
        
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(nums[mid]==target)
                return mid;
            
            //left sorted
            if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target && target<=nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
                
            }
            else
            {
                //Right sorted
               if (nums[mid] <= target && target <= nums[high]) 
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
