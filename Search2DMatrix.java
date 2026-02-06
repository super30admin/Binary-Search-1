// Binary Search O(log n) time, O(1) space

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}