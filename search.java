//33. Search in Rotated Sorted Array

// Time Complexity : O(log n)
// Space Complexity : O(1) since we only used pointers 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// We find mid, 
// check which side of the array is sorted, AT LEAST one side will be sorted 
	//then we check if the target lies between the sorted side extremes
	//if it does then we move our pointers such that it lies in the sorted array and we find the target or return -1
	//if the target doesnt lie in the sorted side, then we eleminate the sorted side of the array and move towards the non-sorted side 

class Solution {
    public int search(int[] nums, int target) {
        //[0,1,2,3,4,5,6]
        //[4,5,6,7,0,1,2]
        // [0,1,2]
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[low] <= nums[mid]){
                //left array is sorted
                if(nums[low] <= target && target < nums[mid]){
                    //target lies on the left sorted side
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                //if right array is sorted
                // [8,1,2,3,4,5,6,7]
                if(nums[mid] < target && target <= nums[high]){
                    // target lies on the right sorted side
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}