
// Time Complexity : O(log n) for reducing search space by half
// Space Complexity :O(1) -> only pointers are used for left, right, mid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchRotatedArray {
    
    public int search(int[] nums, int target) {
        
         
      int high=nums.length-1;    // assign pointers low to start and high to end of array
        int low=0;
        
        while(low<=high){
            
            int mid=low+(high-low/2);           // find mid point
            if(nums[mid]==target) return mid; // if middle element is target then return mid
            
            if(nums[low]<=nums[mid]){                 // check if  lowest element is less than or equal to mid
            if(target>=nums[low] && target<nums[mid]) // which means that the left side is sorted.
                high=mid-1;                           // now check if target lies between low and middle element and reassign high to mid -1 if true
                                                        // to make sure is target is found
            
            else
                low=mid+1;                             // if not move search space to right
            }
            
            else if(target>nums[mid] && target<=nums[high]) //if middle element is greater than target its unsorted on left so move to right half
                    
                    low=mid+1;            // check if target lies between middle and high if true make low to
                 else                   //mid+1 else reassign high to mid-1
                        high=mid-1;
                }
                
                
        
        return -1;
        }
}