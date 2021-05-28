// Time Complexity : O(logm + logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * In this solution, we will find the smallest nearest element for the target by doing a binary search in the first column
 * Once we find the row, we perform binary search in that column
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // we first need to do a binary search on the first column
        // this search is to find the nearest smallest number than target
        int low = 0;
        int high = m - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] == target) {
                // Target found
                return true;
            } else if(target > matrix[mid][0]) {
                
                // This case will occur when we have the last row as the smallest nearest value and next row does not exist
                if(mid+1 >= m) {
                    break;
                }
                
                if(target == matrix[mid+1][0]) {
                    return true;
                } else if(target > matrix[mid+1][0]) {
                    low = mid + 1;
                } else if (target < matrix[mid+1][0]) {
                    high = mid - 1;
                }
            } else {
                // target is less than mid
                high = mid - 1;
            }
        }
        
        // low index will be having the row number which we should search the target element for
        // we call binary search function on the matrix[row] and target
        // if it returns true, element exists and if it returns false, element does not exist in 2D array as a whole.
        
        return binarySearch(matrix[low], target);
    }
    
    public boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target) {
                return true;
            } else if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}