/*
 * Given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You should search for target in nums and if you found return its index, otherwise return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4

 */


/*
 * Time Complexity: O (logN) -> Implemented Binary Search
 * Space Complexity: O (N) -> To store 'n' number of elements
 * Did this code successfully run on leetcode: Yes
 * Any problem you faced while coding this:
 * 	- Since this is unsorted array, faced some issues while trying to come up with a solution
 */
package com.s30.edu.binarysearch1;

public class RotatedSortedArray {
	
	public static int search(int[] nums, int target) {
        // Input validation check
        if (nums == null || nums.length == 0)
            return -1;
        
        // Find the pivot first -> smallest element in the sorted array
        int left = 0;
        int right = nums.length-1;
        
        
        /*
         * For this example: [4,5,6,7,0,1,2]
         * while loop breaks at index 4
         */
        while(left < right){
            int mid = left + (right-left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
                
        } // while loop ends
        
        
        // Check which subpart of unsorted array to traverse to find target
        int start = left; // start with smallest element
        left = 0; // reset the left variable
        right = nums.length - 1;
        
        if(target >= nums[start] && target <= nums[right]){
            left = start;
        }
        else{
            right = start;
        }
        
        // Apply normal binary search
        while(left <= right){
            int midpoint = left + (right-left) / 2;
            if(nums[midpoint] == target){
                return midpoint;
            }else if(nums[midpoint] < target){
                left = midpoint + 1;
            }else{
                right = midpoint-1;
            }
                
            
        }
        return -1; // If target is not found
    
    }
}
