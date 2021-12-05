// Time Complexity: O (log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem2 {
    public int search(int[] nums, int target) {
        
    int low=0;
    int high=nums.length-1;
    
    while(low<=high)
    {
        int mid=low+(high-low)/2;
        if(nums[mid]==target){
           return mid; 
        }            
        // Check for which part is sorted and then check whether element exists there
        else if(nums[low]<=nums[mid])
        {
            if(target>=nums[low] && target<=nums[mid])
            {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        else if (nums[mid]<=nums[high]){
            if(target>=nums[mid] && target<=nums[high])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
            
        }
            
        
    }
        return -1;
    
}}