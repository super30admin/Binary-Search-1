// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Base Case
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length; // Number of rows
        int n = matrix[0].length; // Number of columns

        // Treating the 2D matrix as a virtual 1D array
        int low = 0;
        int high = m * n - 1;

        while (low <= high){
            int mid = low + (high - low) / 2; // To Prevent Integer Overflow

            // Converting 1D index back to 2D coordinates
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true;
            }
            else if(target < matrix[row][col]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}