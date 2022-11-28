public class SearchInSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m*n - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;
            int pivotElement = matrix[pivot/n][pivot%n];

            if (target == pivotElement) return true;
            else if (target < pivotElement) {
                right = pivot - 1;
            }
            else {
                left = pivot + 1;
            }
        }
        return false;
    }
}