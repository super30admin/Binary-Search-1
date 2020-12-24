// Time Complexity : O(logN) - because I am doing binary search
// Space Complexity : O(1) - No extra space is required
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      // m - no. of rows  
       int m = matrix.length;
        if ( m == 0)
        return false;
    // n - no. of columns
       int n = matrix[0].length;
       
       int l = 0;
    // since 2d array can be flattened as 1d array with total elements being m*n, the last index of such  1d array will be m*n-1
       int r = (m * n) - 1;
        
        // binary search
        while ( l <= r)
        {
            int mid = l +(r-l)/2;
            
            // mid/n - gives the row no. and mid % n gives the column no.
            int currentMidElement = matrix[mid / n][mid % n];
            
            if (currentMidElement == target)
                   return true;
            
            else if (currentMidElement < target)
            {
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }
        return false;
    }
}
