// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
 * We could try imagining 2D matrix as 1d matrix and then map the indexes to 2D row and col.
We are given that last element of row i < first element of row i+1 and thus we could use mod and 
div to get the row and col in range.
 */
class BinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low =  0;
        int high = m*n - 1;
        while(low <= high) { 
            int mid = low + (high-low)/2;
            int row = mid / n;
            int column = mid % n;
            if(matrix[row][column] == target) {
                return true;
            }
            if(matrix[row][column] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}