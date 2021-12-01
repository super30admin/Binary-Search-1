# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

//Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        int l = 0, r = m * n - 1;
        int index, element;
        while (l <= r) {
            index = (l + r) / 2;
            element = matrix[index / n][index % n];
            if (target == element)
                return true;
            else {
                if (target < element)
                    r = index - 1;
                else
                    l = index + 1;
            }
        }
        return false;
    }
}

## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

//Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int search(int[] nums, int target) {
        int low= 0;
        int high = nums.length-1;
        
        
        while(low<=high) {
            int mid = low + (high-low)/2; //Integer Overflow
            
            //found the number
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        // for (int i=0; i<nums.length; i++) {
        //     if (target==nums[mid]){
        //         return mid;
        //     }
        //     else if(nums[mid]<target){
        //         low = mid+1;
        //     }
        //     else
        //         high=mid-1;
        // }
        
        return -1;
    }
    
}



## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

//Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int search(ArrayReader reader, int target) {
      if (reader.get(0) == target) return 0;
  
      int l = 0, r = 1;
      while (reader.get(r) < target) {
        l = r;
        r = r*2;
      }

      int p, num;
      while (l <= r) {
        p = l + ((r - l) >> 1);
        num = reader.get(p);
  
        if (num == target) return p;
        if (num > target) r = p - 1;
        else l = p + 1;
      }

      return -1;
    }
  }