class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target,
                            0, (matrix.length * matrix[0].length - 1), matrix[0].length);
    }

    private boolean searchMatrix(int[][] matrix, int target, int left, int right, int n) {
        if (left > right) {
            return false;
        }

        int mid = left + (right - left)/2;

        int midRow = mid/n;
        int midCol = mid%n;

        int midVal = matrix[midRow][midCol];
        if (target == midVal) {
            return true;
        } else if (target < midVal) {
            return searchMatrix(matrix, target, left, mid - 1, n);
        } else {
            return searchMatrix(matrix, target, mid + 1, right, n);
        }
    }
}
