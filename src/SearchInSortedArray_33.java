// Time Complexity : O(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
 */



// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
     
        if(nums == null || nums.length == 0) return -1;
        
        int low =0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) return mid;
            
            if(nums[low] <= nums[mid]) { //left array is sorted
               if(target >= nums[low] && target < nums[mid]) { // target lies between left array
                   high = mid - 1;
               }else {
                   low = mid + 1; // target lies outside left sorted array
               }
            } else { // right array is sorted
                 if(target > nums[mid] && target <= nums[high]) { //target lies between right sorted array
                   low = mid + 1;
               }else {
                   high = mid - 1; // target lies outside right sorted array
               }
            }
        }
        
        return -1;
    }
}