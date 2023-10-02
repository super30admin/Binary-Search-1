// Search in a Rotated Sorted Array

//Time complexity O(log n)
//Space complexity 0(1)

// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int search(int[] nums, int target) {
        //one side should be sorted
        int low = 0;
        int high = nums.length - 1;
        // Get the sorted Array Range
        while (low<=high){

            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }
            //left side sorted
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]){
                    //element in left side
                    high = mid - 1;
                } else {
                    //element in right side
                    low = mid + 1;
                }
            } else {
                //right side sorted
                if(nums[mid]<target && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}