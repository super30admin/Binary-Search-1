public class Search2DMatrix1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = left + (right - left) + 1 / 2;
            int row = mid / n;
            int column = mid % n;

            if (matrix[row][column] == target)
                return true;
            if (target < matrix[row][column]) {
                right = mid - 1;
            } else
                left = mid + 1;

        }
        return false;
    }

}
