// Time Complexity : Not sure about this
// Space Complexity : Not sure about this
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes I was not sure about how to solve problem with pivot element instead of entire sorted array.


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {

        int low=0;
        int high=nums.length-1;
        int mid=0;

        if(nums.length==0||nums==null)
            return -1;

        while(low<=high)
        {
            mid = (high + low)/2;
            if(nums[mid]==target)
                return mid;

            if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(nums[high]>=target)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }

        if(nums[low]==target)
            return low;
        if(nums[high]==target)
            return high;

        return -1;
    }
}