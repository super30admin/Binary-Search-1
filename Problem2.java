//Time complexity- logn
//The list is partially sorted between mid and low or mid and high and we are move according to low ,high and mid compared to target

class Solution {
    public int search(int[] nums, int target) {
     int low=0,high=nums.length-1;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[low]<=nums[mid])
            {
            if(target<nums[mid] && target>=nums[low])
                high=mid-1;
            else
                low=mid+1;
                }
            else
            {
                if(target>nums[mid] && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
                        
            }
                
        }
        return nums[low]==target?low:-1;
    }
}