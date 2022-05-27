// Complexity is log(m) where m is the size of the rotated array
class Solution {
    public int search(int[] nums, int target) {
     int low, high, mid;
      low=0; high=nums.length-1; mid= low + ((high-low)/2); 
      
        while(low<=high)
        {
            mid= (low+high)/2;
           
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid])
            {
                if(target>=nums[low] && target<nums[mid])
                    high= mid-1;
                else
                low = mid+1;
            }
            else
            {
                if(nums[mid]<target && nums[high]>=target)
                    low = mid+1;
                else
                    high= mid-1;
            }
                
        }
        return -1;
        
    }
}