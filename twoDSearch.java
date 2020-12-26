//Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// Time Complexity : O(logm+logn) where m and n are the length of rows and columns respectively
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class twoDSearch{
    public boolean searchMatrix(int[][] matrix, int target) {
        int low_row = 0;
        int low_column = 0;
        int high_row = matrix.length - 1;
        if (high_row == -1)
            return false;

        int high_column = matrix[0].length - 1;
        if (high_column == -1)
            return false;

        int row = -1;
        while (low_row <= high_row) {
            int mid_row = low_row + (high_row - low_row) / 2;
            if (matrix[mid_row][0] <= target && matrix[mid_row][high_column] >= target) {
                row = mid_row;
                break;
            }
            if (matrix[mid_row][0] > target) {
                high_row = mid_row - 1;
            } else if (matrix[mid_row][high_column] < target) {
                low_row = mid_row + 1;
            }
        }
        if (row == -1)
            return false;

        while (low_column <= high_column) {
            int mid_column = low_column + (high_column - low_column) / 2;
            if (matrix[row][mid_column] == target) {
                return true;
            }
            if (matrix[row][mid_column] < target) {
                low_column = mid_column + 1;
            } else {
                high_column = mid_column - 1;
            }
        }
        return false;

    }
}