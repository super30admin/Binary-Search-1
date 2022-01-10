/* Problem 2: Search inside rotated sorted array
*/
// Time Complexity : O(log n)
// Space Complexity : O(1) since we are not using any auxiliary space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Follow up question(interviewer): Can we do this in single pass?
//Pattern: In rotated sorted array, it doesn't matter where middle index is,
//one part of array will always be sorted.
//First, initialise low and high pointers in the array
//initialise mid pointer and create 3 cases
//Case 1) if mid index value == target, return mid
//Case 2) check if left side is sorted, by comparing low < mid
//Case 2.1) if its true, check if target falls in this left sorted array and apply binary search
//Case3) if its false, check if target falls in right sorted array and apply binary search

class Solution {
    public int search(int[] nums, int target) {
        //[4,5,6,7,0,1,2]
        //low and high pointers
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            //Case1) check if mid == target
            if(nums[mid] == target) return mid;
            //Case2) check if left side is sorted
            else if(nums[low] <= nums[mid]){
                //in left sorted array, check if target falls in this side
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
                    
            }
            //Case3) check if right side is sorted
            else {
                //in right sorted array, check if target falls in this side
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}