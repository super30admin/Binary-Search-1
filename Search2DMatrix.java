
/**
 *
 * Time Complexity: O(log(R * C))
 * Space Complexity: O(1)
 * R = Number of rows. C = Number of columns.
 */
class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            throw new IllegalArgumentException("Input is null");
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int cols = matrix[0].length;
        int start = 0;
        int end = matrix.length * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if (target == matrix[row][col]) {
                return true;
            }
            if (target < matrix[row][col]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix sol = new Search2DMatrix();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;
        boolean result = sol.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result); // true

        target = 13;
        result = sol.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result); // false
    }
}
