// Approach:
// Treat the 2D matrix as a sorted 1D array by using index math to map midpoints back to row and column.
// Perform a standard binary search on the range [0, m*n - 1], comparing the target to the element at the “flattened” mid index.
// Return true if found; otherwise adjust left/right until the search space is empty and return false.

// Time Complexity : O(log(m * n))  
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No  

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // number of rows
        int m = matrix.length;
        // number of columns (assume at least one row exists)
        int n = matrix[0].length;
        
        // pointers for binary search on the virtual flattened array
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            // find mid index in flattened space
            int mid = left+(right - left) / 2;  // middle index
            // map flat index back to row and column
            int row = mid / n;
            int col = mid % n;
            int midVal = matrix[row][col];  // element at the mid position
            
            // if we found the target, return true
            if (midVal == target) {
                return true;
            }
            // if mid value is less, move left pointer to search right half
            else if (midVal < target) {
                left = mid + 1;
            }
            // else search left half
            else {
                right = mid - 1;
            }
        }
        
        // target was not found
        return false;
    }
}
