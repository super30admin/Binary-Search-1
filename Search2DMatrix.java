public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // no: of rows
        int n = matrix[0].length; // no: of columns
        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}

/**
 * We can visualize the 2D matrix as a 1D sorted array.
 * The row index can be calculated as mid / number_of_columns.
 * The column index can be calculated as mid % number_of_columns.
 * Using binary search, we efficiently search for the target.
 * <p>
 * Time Complexity: O(log (m * n))  // Binary search over m * n elements
 * Space Complexity: O(1)  // No extra space used
 */