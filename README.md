# Binary-Search-1
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach:-
At least one half (left or right) of the array is always sorted.
We check which half is sorted and decide whether the target lies in that range.
Based on that, we adjust left and right to perform binary search accordingly.

## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m*n)-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            int row = mid/n;
            int col = mid%n;

            if(target == matrix[row][col]){
                return true;
            }

            else if(target < matrix[row][col]){
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }

        return false;
    }
}

## Problem2 
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach:-
In this question we make a very important observation that after calculating mid atleast 1 side of the mid is sorted.
So, we will first check wether the target element lies in the sorted side(checking if left side of mid is sorted) of the mid if yes, then we will do right = mid-1
else it means that the right side is sorted so we will check in the wether the target element belongs to right sorted side of mid if yes, then we will do left - mid +1
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

## Problem3
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

