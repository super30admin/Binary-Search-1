/* Exercise 1- 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//follow up questions for interviewer(if not given in question): if the length of an array is given, array is sorted or not and if duplicates exist within the array
//Approach - Lets consider an array where we assign low, mid and high pointers
//we will follow binary search and 
//case1)if target is equal to mid indexed value, return mid index
//case2) left sorted: means if low value is less than mid value && low<=target and target<=mid, the target is present in left side
//case3)right sorted: means if target is present in the right side of mid index when mid<= target and target<=high
//both the cases, change high and low pointers if it fails as well

class Solution {
    public int search(int[] nums, int target) {
        //edge case
        if(nums == null || nums.length == 0) 
            return -1;
        //intialise low and high pointers
        int low = 0;
        int high = nums.length - 1;
        //terminating condition
        while(low <= high){
            //Note: always take care of Integer Overflow problem
            //with assigning mid pointer
            //so if you consider mid = (low+high)/2, the high number will result in negative integer
            int mid = low + (high-low)/2;
            //base case of binary search
            if(nums[mid] == target) 
                return mid;
            else if(nums[low] <= nums[mid]){
                //left sorted
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            } else {
                //right sorted
                if(nums[mid] <= target && nums[high] >= target){
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