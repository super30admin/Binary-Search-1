// Problem3 Search 2D Matrix

public class Search2DMatrix {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix == null || matrix.length == 0)
                return false;

            int m = matrix.length;
            int n = matrix[0].length;

            int low = 0;
            int high = m * n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int row = mid / n;
                int col = mid % n;
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }
}