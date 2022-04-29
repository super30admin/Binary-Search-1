// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        //Initialise  start and end points of array
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start +(end-start)/2; //dind middle of array
            if(nums[mid]==target){
                return mid; //if its the target return index
            }
            else if(nums[mid]>=nums[start]){ //only if mid value is greater or same than start
                if(target>=nums[start] && target<nums[mid]){ //we find the location and update start and end accordingly
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target<=nums[end] && target>nums[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;//if value not present
    }
}