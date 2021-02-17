//Time complexity: O(logn) every time we are removing a half of the array
//Space complexity: O(1) 
//Compiled in leetcode.

class Solution {
    public int search(int[] nums, int target) {
        
        int l =0 , r= nums.length-1;
        int mid = l+(r-l)/2;					//l, r and mid indicates left, right and middle value of the array
        
        while(l<=r)									// we traverse through array untill l<=r
        {
            if(nums[mid]==target)
            {
                return mid;								//return mid index if matches with target
            }
            else
            {
                if(nums[l]<=nums[mid])
                {
                    if(nums[l]<=target && nums[mid]>=target)			// Confirming if the particular array is in sorted list or not and
                    {														//checking if target is between and reassigning l and mid values based on that
                        r = mid-1;
                    }
                    else
                    {
                        l = mid+1;
                    }
                }
                else
                {
                    if(nums[r]>=target && nums[mid]<=target)		//checking if target is between and reassigning mid and r values based on that
                    {
                        l = mid+1;
                    }
                    else
                    {
                        r = mid-1;
                    }
                }
            }
            mid = l+(r-l)/2;
        }
        return -1;
        
    }
}