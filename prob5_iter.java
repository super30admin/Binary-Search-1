// 33. Search in Rotated Sorted Array
// S30 Big N Problem #5 {Easy}
// Time Complexity :O(log n) binary search
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// Iterative solution
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2; // (low+high)/2 integer overflow problem
            //base condition
            if(nums[mid] == target) return mid;
            //logic
            if(nums[low]<=nums[mid]){//left array ->sorted
                if(nums[mid]>target && nums[low]<=target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }else{ //right array ->sorted 
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