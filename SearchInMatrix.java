// Time Complexity : O(log(mn)), m is no. of rows and n is no. of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Treated this 2D matrix as a 1D array. 
// Found the mid element by using [mid/col] to get row index as this will give me the index where the row breaks
// and [mid%col] to get col index as this will give me the index that where my current mid is located in that row.
// Applied binary search using the above mid.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) {
            return false;
        }            
        int row = matrix.length, col = matrix[0].length;        
        int start = 0, end = row*col-1;

        while(start <= end) {
            int mid = (start + end)/2;
            
            int midElement = matrix[mid/col][mid%col];
            
            if(target == midElement) {
                return true;
            }
            
            if(target < midElement) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return false;
    }
}