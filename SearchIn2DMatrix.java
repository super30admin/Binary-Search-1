/**
// Time Complexity : O(logmn) since we are the applying the binary search on entire array size rows * cols.
// Space Complexity : total space = O(m * n) (input 2D array size) + O(1) constant time.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

**/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        return applyBinarySearch(rows, target, cols, matrix);
        
    } 
    
    private boolean applyBinarySearch(int rows, int target, int cols, int matrix[][])
    {
        int low = 0;
        int high = (rows * cols) - 1;
        
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            
            int row = mid / cols;
            int col = mid % cols;
            
            if (target > matrix[row][col])
            {
                low = mid + 1;
            }
            else if (target < matrix[row][col])
            {
                high = mid - 1;
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
    
}