// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0) return -1;
        
        int n=nums.length;
        int low=0;
        int high=n-1;
        
        while(low <=high){
            int mid=low+(high-low)/2;//to avoid integer overflow
            if(nums[mid] == target){
                return mid;
            }//check which part is sorted 
            else if(nums[low] <= nums[mid]){//left is sorted in this case
                if(target >=nums[low] && target < nums[mid]){
                    high=mid -1;
                }
                else{
                    low=mid-1;
                }
            }
            else{
                //right part is sorted
                //check the target is lying in the right half
                if(target > nums[mid] && target <= nums[high]){
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