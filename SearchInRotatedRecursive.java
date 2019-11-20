//Time . complexity : O(logn)
//Space: O(n) : because there are recursive calls and we are manitaining stacks of the size of n in worst case

class Solution {
  public int search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    return binarySearch(nums, start, end, target);
  }
    
   
    int binarySearch(int[] nums, int start, int end, int target)
    {
        if(start>end)
            return -1;
        
        int mid=start+(end-start)/2;
       if(target == nums[mid])
           return mid;
       
       //check if right half is sorted, check equals because mid and start can be at same index and that should not result false
     if (nums[start] <= nums[mid])
       {
           //check for target 
           if(target>=nums[start] && target<= nums[mid])
           {
               end=mid-1;
           }
           else
           {
               start=mid+1;
           }
           
       }
       //else left is sorted
       else
       {
           if(target>=nums[mid] && target<=nums[end])
           {
               start=mid+1;
           }
           else
           {
               end=mid-1;
           }
       }
        //when start and end are set to their positions, do recursive call
      return  binarySearch(nums, start, end, target);
    }  
   
}
