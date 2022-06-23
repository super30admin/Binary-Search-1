// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length; // no. of rows
        int n = matrix[0].length; // no. of columns
        int low = 0;
        int high = m * n - 1; // total no. of elements -1

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n; // to obtain the row number
            int column = mid % n; // to obtain the column number
            if (matrix[row][column] == target) {
                return true;
            } else if (target > matrix[row][column]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;

    }
}