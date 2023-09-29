public class serachIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int h = m * n - 1;

        while (l <= h) {
            m = l + (h - l) / 2;
            int r = m / n;
            int c = m % n;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
