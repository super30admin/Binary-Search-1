// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// Time Complexity : O(logm + logn) for an m x n matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Thinking about the edge case of not finding a valid row. 


// Your code here along with comments explaining your approach
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Performed binary search on rows. 
        int row_low = 0, row_high = matrix.length - 1;
        while(row_low<=row_high) {
            int row_mid = row_low + (row_high-row_low)/2; 
            if(matrix[row_mid][0] == target) return true;
            if(matrix[row_mid][0] > target) row_high=row_mid-1;
            else row_low=row_mid+1;
        }
        
        //If a valid row is found, performed binary search on columns. 
        if(row_high >= 0){
            int col_low=0, col_high=matrix[0].length-1;
             while(col_low<=col_high) {
                int col_mid = col_low + (col_high-col_low)/2; 
                if(matrix[row_high][col_mid] == target) return true;
                if(matrix[row_high][col_mid] > target) col_high=col_mid-1;
                else col_low=col_mid+1;
            }
        }
        
        return false;
    }
}