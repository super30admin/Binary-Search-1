// Time: log(m*n)
// Space: 1
class TwoDMatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false; // Invalid matrix
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int rowOfMid = mid / n;
            int colOfMid = mid % n;

            if (matrix[rowOfMid][colOfMid] == target) {
                return true;
            }

            if (target < matrix[rowOfMid][colOfMid]) {
                // Search in left subarray
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
