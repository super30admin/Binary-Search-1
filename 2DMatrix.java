//TC: log(m*n)
//SC: o(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int hi = m * n - 1;

        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            int r = mid / n;
            int c = mid % n;
            if (matrix[r][c] == target)
                return true;
            if (matrix[r][c] > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return false;
    }
}