// Time Complexity : o(log(n))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(nums[mid]==target)return mid;
            else if(nums[low]<=nums[mid]){ //left sorted
                 if(nums[mid]>target && nums[low]<=target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
              }
            else{
                 if(nums[mid]<target && nums[high]>=target){
                    low=mid+1;
                }
                else{
                    high=mid-1;

                }
               }
            }
            return -1;
    }
}
