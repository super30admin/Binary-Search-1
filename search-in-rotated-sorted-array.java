class Solution {
    //Time O(logN)
    //Space O(1)
/*
  BruteForce: we can iterate whole array in O(N) 
  Optimized : we can reduce the search space by half by validating element lies in sorted part of the else it lies in unsorted part.
*/
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
       int low = 0 , high = nums.length-1;
       while(low <= high)
       {
           int mid = low + (high-low)/2;
           if(nums[mid] == target)
           {
               return mid;
           }
           if(nums[low] <= nums[mid])
           {
               if(nums[low] <= target &&  target < nums[mid])
               {
                   high = mid-1;
               }
               else
               {
                   low = mid+1;
               }
           }
           else
           {
               if(nums[mid] < target && target <= nums[high])
               {
                   low = mid+1;
               }
               else
               {
                   high = mid-1;
               }
           }
       }
        return -1;
    }
}
