// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Approach: Checking whether the input array is left or right sorted at mid, followed by binary search.


class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target){return mid;}
            else if(nums[l]<=nums[mid]){
                if(nums[l]<=target && nums[mid]>target){
                    r=mid-1;
                }
                else{l=mid+1;}
            }
            else{
                if(nums[mid]<target && nums[r]>=target){
                    l=mid+1;
                }
                else{r=mid-1;}
            }

        }
        if(nums[r]==target) {return r;}
        return -1;
    }
}
