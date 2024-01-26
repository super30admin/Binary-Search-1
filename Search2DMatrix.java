// Time Complexity : O(log M*N) = O(logM + logN)
// Space Complexity : O(1)


// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10^4 <= matrix[i][j], target <= 10^4

public class Search2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int low = 0;
            int high = rows * cols - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int currRow = mid / cols;
                int currCol = mid % cols;
                if (matrix[currRow][currCol] == target) {
                    return true;
                }
                if (matrix[currRow][currCol] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return false;
        }
    }
}
