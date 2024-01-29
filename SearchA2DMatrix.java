
// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

//The approach for this problem is to flatten the 2D array into a 1D array and then apply binary search.

class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        // If the matrix is empty (has zero rows), the function immediately returns
        // false
        if (matrix.length == 0) {
            return false;
        }

        // m is the number of rows in the matrix, n is the number of columns in the
        // matrix.
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}