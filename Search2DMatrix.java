public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, r = matrix.length, c = matrix[0].length;
        int end = r * c - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / c][mid % c] == target) {
                return true;
            }
            if (matrix[mid / c][mid % c] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}