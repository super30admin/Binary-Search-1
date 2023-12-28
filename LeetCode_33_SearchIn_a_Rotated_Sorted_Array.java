/*
approach -1
linear search - tc : O(n), sc:O(1)*/

/*
approach-2
Binary search
1. comapre the mid with low and high, to figure which part is sorted.
tc: O(log n)*/

class Solution {
    public int search(int[] nums, int target) {
        //base case
        if(nums == null || nums.length ==0) return -1;
        
        
        //perform regular bu=inary search
        int low=0, high =nums.length -1;
        
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            
            //check if target is mid
            if(nums[mid] ==  target) return mid;
            
            //lleft sorted side, 
            else if(nums[low] <= nums[mid])
            {
                //if target lies here?
              if(nums[low]<= target && target < nums[mid])
              {
                  high =mid-1;
              }else
              {
                  low = mid+1;
              }
            }
            else //right side is sorted
            {
                //check if target is here
                if(nums[mid]< target && target <= nums[high])
                {
                    low = mid+1;
                }else
                {
                    high = mid-1;
                }
            }
        }
        return -1; //if never found!
    }
}