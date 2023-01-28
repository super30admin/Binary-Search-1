// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//I treated the matrix as a linear array and applied binary search on it. low is initially set to 0 and high is set to m*n-1. We apply binary search then and obtain the row index as mid/columns and column index as mid%columns.




class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0,high=rows*columns-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int r = mid/columns;
            int c = mid%columns;
            if(matrix[r][c]==target)
            {
                return true;
            }
            else if(matrix[r][c]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return false;
    }
}