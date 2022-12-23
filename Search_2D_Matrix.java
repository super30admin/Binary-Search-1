// Time Complexity : o(logN + log M) 
// Space Complexity : o(2);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;

        // check row and column simultaneously and accordingly 
        // perform binary search.
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
