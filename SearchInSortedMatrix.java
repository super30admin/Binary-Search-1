// Time Complexity : O(Log2 N). Where N = Rows * Cols.
// Space Complexity : O(1). No extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // set lo = 0, hi = total elem in matrix - 1 (i.e Row * Col - 1)
        int len = matrix.length * matrix[0].length;
        int lo = 0, hi = len - 1;
        
        // Simple BinSerach
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            // After Getting mid
            // Calculate midRow and MidCol using following
            int midRow = mid / matrix[0].length;
            int midCol = mid  % matrix[0].length;
            
            // Continue with BinSearch Logic
            if(matrix[midRow][midCol] == target)
            {
                return true;
            }
            else if(target > matrix[midRow][midCol])
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        
        return false;
    }
}