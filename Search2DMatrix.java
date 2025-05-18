public class Search2DMatrix {
    /*
    Flatten the 2d array as a single array of size m * n and perform binary search.
    Use division and modulo on mid index by number of columns to find corresponding
    row and column of mid index in the matrix
    Time: lon (m * n)
    Space: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m *n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
