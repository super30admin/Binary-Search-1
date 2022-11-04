import java.util.Objects;
/**
 * TC - O(log n)
 * SC - O(1)
 */
public class MatrixSearch {
        public boolean searchMatrix(int[][] matrix, int target) {

            if (Objects.isNull(matrix) || matrix.length == 0) {
                return false;
            }

            int row = matrix.length;
            int column = matrix[0].length;
            int totalElements = row * column;

            int low = 0;
            int high = totalElements - 1;

            while(low <= high) {
                int mid = low + (high - low) / 2;

                int midRow = mid / column;

                int midCol = mid % column;

                if (matrix[midRow][midCol] == target) {
                    return true;
                }

                if (matrix[midRow][midCol] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
}
