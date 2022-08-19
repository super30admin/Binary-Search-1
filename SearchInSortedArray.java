/*******
## Problem 1: Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. 
Accessing an element out of bounds throws exception. 
If the number occurs multiple times, return the index of any occurrence. 
If it isn’t present, return -1.

Time Complexity :   O (logT) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (702. Search in a Sorted Array of Unknown Size)
Any problem you faced while coding this :       No
*******/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

interface ArrayReader {
    public int get(int index) {}
}

class Solution {
    public int search(ArrayReader reader, int target) {
        // if target is at first index
        if (reader.get(0) == target){
            return 0;
        }
        
        // find left and right boundries
        int left = 0;
        int right = 1;
        
        while (reader.get(right) <= target){
            left = right;
            right = right * 2;
        }
        
        // perform binary search
        int midIndex, mid;
        while ( left <= right ){
            midIndex = (right + left) / 2;
            mid = reader.get(midIndex);
        
            if (mid == target){
                return midIndex;
            }
            else if (mid > target){
                right = midIndex - 1;
            }
            else if (mid < target){
                left = midIndex + 1;
            }
        }
        
        // return -1 if element not found
        return -1;   
    }
}