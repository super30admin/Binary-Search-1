
public class SearchTwoDMatrix {
    /*
     * Time Complexity: O(log(m*n)) where we reduce the matrix by implementing Binary search
     * Space Complexity: O(1) as no extra space is used
     *
     * Search target value in an m*n 2D matrix
     *
     * Author: Aditya Mulik
     */

    public static boolean searchMatrix(int[][] matrix, int target) {

        // base case
        if (matrix == null || matrix.length == 0) return false;

        // Find the row and col of matrix
        int m = matrix.length;
        int n = matrix[0].length;
//        System.out.println(rowIndex + " " + colIndex);
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
//            System.out.println(rowIndex + " " + colIndex);
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3}};
        int target = 3;

        boolean answer = searchMatrix(matrix, target);
        System.out.println(answer);
    }
}
