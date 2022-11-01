# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    if( matrix == null || matrix.length==0) return false;
        
        int m = matrix.length;
        int n= matrix[0].length;
        
        int low=0;
        int high = m*n-1;
        while(low<=high){
            int mid =low +(high-low)/2;
            int row = mid/n;
            int col=mid%n;
            
            if(matrix[row][col]==target){
                return true;
            }
            else{
                if(target>matrix[row][col]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}

## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        
        int n =nums.length;
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low]&& target<nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
                
            }
        else{
            if(target>nums[mid]&& target<=nums[high]){
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




## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

