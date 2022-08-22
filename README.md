# Binary-Search-1


## Problem1: Search a 2D Matrix

```Java
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //check null
        if(matrix == null || matrix.length==0)
            return false;

        //number of rows and columns
        int n = matrix.length;
        int m = matrix[0].length;

        int low=0;
        int high=m*n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            //index of mid element
            int rowIndex = mid/m;
            int colIndex = mid%m;

            //check if mid is the target
            if(matrix[rowIndex][colIndex] == target)
                return true;
            else if(matrix[rowIndex][colIndex] > target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}
```

## Problem2: Search in Infinite sorted array: 

```Java
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;

        while(reader.get(high) < target){
            low=high;
            high=2*high;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
```

## Problem3: Search in a Rotated Sorted Array

```Java
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public int search(int[] nums, int target) {
int low = 0;
int high = nums.length-1;

        while(low<=high){
            int mid = low + (high - low)/2;
            //checking if mid is the target
            if(nums[mid] == target){
                return mid;
            }
            //check if left search required?
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid + 1;
                }
            }
            //right search required?
            else{
                if(target <= nums[high] && target > nums[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid- 1;
                }
            }
        }
        return -1;
    }
}
```

