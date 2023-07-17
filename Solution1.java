//Search-in-rotated-sorted-array
//Time Complexity:O(logn)
//Space Complexity:O(1)
class Solution1 {
    public int search(int[] nums, int target) {
        //check which part of array is sorted 
        //left or right part
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            //left side is sorted
            if(nums[low]<=nums[mid])
            {
                //chk if target lies in left side
                if(nums[low]<=target && target<nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1; //go to right side
                    //target lies in unsorted /right part
                }
            }
            else //right side is sorted
            {
                // chk if target lies in that range
                if(nums[high]>=target && target>nums[mid])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;//not found
    }
}