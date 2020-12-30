# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

Linear Search: 
// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }   
    return false;
    }
}

Binary Search: 
// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0;
        int h=m*n - 1;
        while(l<=h){
            int mid = l + (h-l)/2;
            int row = mid / n;
            int column = mid % n;
            if(matrix[row][column]==target){
                return true;
            }    
            else if(target > matrix[row][column]){
                l = mid + 1;
            }
            else{
                h = mid -1;
            }
        }
        return false;
    }
}







## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]==target){
                return mid;
            }

            // left is sorted
            if(nums[mid]>=nums[l]){
                if(target>=nums[l] && target <= nums[mid]){
                    h = mid - 1;    
                }
                else{
                    l = mid + 1;
                }
            }
            //right is sorted
            else{
                if(target>=nums[mid] && target<=nums[h]){
                    l = mid+1;
                }
                else{
                    h = mid - 1;
                }
            }    
        }
    return -1;
    }
}



## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Time Complexity : O(log n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, it was straight forward


// Your code here along with comments explaining your approach

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int bsearch(ArrayReader reader, int l, int h, int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if (target > reader.get(mid)){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return -1;
    }
    
    public int search(ArrayReader reader, int target) {
        int l=0;
        int h=1;
        /* // not required 
        if(reader.get(l)==target){
            return l;
        }
        else if(reader.get(h)==target){
            return h;
        }
        */
        while(target > reader.get(h)){ // Integer.MAX_VALUE > reader.get(h) can be added
            l = h;
            h = h * 2;
        }
        return bsearch(reader, l, h, target);
    }
}