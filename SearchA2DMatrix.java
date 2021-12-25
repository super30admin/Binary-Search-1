// Time Complexity : O(log(m)) + O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
/*
    Use binary search to first find the appropriate row - takes log(m)
    Use binary search to find appropriate element (or column) - takes log(n)
 */
class Solution {

    private int findRow(int[][] matrix, int target) {
        int n = matrix[0].length - 1;

        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n])
                return mid;
            else {
                if (target > matrix[mid][n])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    private boolean findCol(int[][] matrix, int row, int target) {
        int low = 0;
        int high = matrix[0].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target)
                return true;
            else {
                if (target > matrix[row][mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int row = findRow(matrix, target);
        return row < 0 ? false : findCol(matrix, row, target);
    }
}