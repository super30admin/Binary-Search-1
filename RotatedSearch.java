class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    
    public int binarySearch(int[] nums, int target, int low, int high)
    {
        if(low<=high)
        {
        int mid = (low+high)/2;
        
        if(nums[mid]==target)
        {
            return mid;
        }
        
        if(nums[low]<=nums[mid])
        {
            if(target>=nums[low] && target<nums[mid])
            {
                return binarySearch(nums,target,low,mid-1);
                
            }
            else
            {
                return binarySearch(nums,target,mid+1,high);
            }
        }
        else if(nums[mid]<nums[high])
        {
          if(target>nums[mid] && target<=nums[high])
            {
                return binarySearch(nums,target,mid+1,high);
                
            }
            else
            {
                return binarySearch(nums,target,low,mid-1);
            }   
        }
        }
        return -1;
    }
    
}
