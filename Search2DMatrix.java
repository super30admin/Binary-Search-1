/*
 * Time Complexity : O(log n*m)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 * Your code here along with comments explaining your approach in three
 * sentences only:
 * Binary search on first column, then binary search on the row with potential
 * result
 */

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search first column
        int low = 0;
        int high = matrix.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (matrix[mid][0] == target)
                return true;

            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // after this loop ends; high marks the row to be searched
        // running binary search on this row
        int potentialRow = high;

        // target is smaller than the smallest number
        if (potentialRow < 0)
            return false;

        low = 0;
        high = matrix[potentialRow].length - 1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (matrix[potentialRow][mid] == target)
                return true;

            if (matrix[potentialRow][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
