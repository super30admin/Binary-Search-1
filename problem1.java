// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. Just used 1D binary search by mapping index to row/col.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        // treat 2D matrix like 1D sorted array
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // convert mid into row and col
            int row = mid / n;
            int col = mid % n;

            int val = matrix[row][col];

            if (val == target) return true;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}
