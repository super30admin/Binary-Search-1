/*
 * Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.

 

Example 1:

Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

You may assume that all elements in the array are unique.
The value of each element in the array will be in the range [-9999, 9999].
The length of the array will be in the range [1, 10^4].

 */

package com.s30.edu.binarysearch1;

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
interface ArrayReader {
	      public int get(int index);
	  }



/*
 * Time Complexity: 
 * 	- Setting up the search boundaries -> O (logN)
 * 	- Performing Binary Search to find the target element -> O (logN)
 * 
 * Space Complexity: 
 * 
 * Did this code successfully run on leetcode: Yes
 * Any problem you faced while coding this: Tried other approach but time complexity was not as expected
 */

public class InfiniteSortedArray {
	 public int search(ArrayReader reader, int target) {
	        
	        // Check if the target is present at 0th index
	        if(reader.get(0) == target)
	            return 0;
	        
	        // If target is not found at 0th index
	        
	        /* 
	        * Subproblem 1 -> Set the boundaries
	        */
	        
	        // Initialize the boundaries
	        int left = 0;
	        int right = 1;
	        
	        // If true, then target is definitely beyond our boundaries, extend our boundaries
	        while(reader.get(right) < target){
	            left = right; // move the left boundary by 1, assign right boundary index to it
	            //right = right * 2;
	            // Extend the right boundary such that we get logarithmic time complexity
	            right <<= 1; // To speed up operation use left shift instead of multiplication 
	        }
	        
	        /*
	        * Subproblem 2 -> Perform Binary Search
	        */
	        
	        int mid, num;
	        while(left <= right){
	            mid = left + ((right-left) >> 1); // Use this right shift operation instead of left+right/2 to avoid overflow problem, x >> 1 instead of x / 2
	            num = reader.get(mid);
	            
	            if(num == target){
	                return mid;
	            }
	            else if(num < target){
	                left = mid+1;
	            }
	            else{
	                right = mid-1;
	            }

	        }
	        return -1; // If target not found 
	        
	    }
}
