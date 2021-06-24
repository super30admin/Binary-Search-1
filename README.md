# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int hi = (n*m)-1;
        while(low<=hi){
            int mid = (low+(hi-low)/2);
            if(matrix[mid/m][mid%m] == target){
                return true;
            }
            if(matrix[mid/m][mid%m] < target){
                low = mid+1;
            }else {
                hi = mid-1;
            }
            
        }
        return false;
        }
    }
/**
The time complexity will be O(logn) since we are performing binary search.
The space complexity will be O(1).
*/


## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[lo]<=nums[mid]){
                if(target>=nums[lo]&&target<=nums[mid]){
                    hi = mid -1;
                }
                else{
                    lo = mid+1;
                }
            }
            else{
                if(target >=nums[mid] && target <=nums[hi]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}


## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

