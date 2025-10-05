// Finding the target by converting the 2D matrix into 1D array
// Time Complexity : O (log (m*n))
// Space Complexity: O (1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length; // no of rows
        int columns = matrix[0].length; // no of columns

        int low = 0;
        int high = rows * columns - 1;

        while (low <= high) {
            int mid = low + (high - low)/2; // to avoid integer overflow

            // Calculate the row and columns index for the mid
            int r = mid / columns;
            int c = mid % columns;

            // If target is found, return
            if (matrix[r][c] == target) {
                return true;
            }

            if (matrix[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return false;
    }
}