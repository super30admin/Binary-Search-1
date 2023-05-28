// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// as we know one side of the array if always sorted we can consider the sorted side to check if target lies in the range of sorted side.
// if not we can choose the unsorted side.
class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        if(nums== null || high==-1) return -1;
        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]) //left sorted
            {
                if((nums[low]<= target ) && (nums[mid]>= target)){ // target lies in range 
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            } else {
                // right sorted
                if((nums[mid]<= target ) && (nums[high]>= target)){ // target lies in range 
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }   
        }
        return -1;
    }
}