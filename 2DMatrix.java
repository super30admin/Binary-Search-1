// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        int mid, r, c;

        if (matrix == null || matrix.length == 0) {
            return false;
        }


        while (low<=high) {
            mid = low + (high - low)/2;
            r = mid / n;
            c = mid % n;
            if ( target == matrix[r][c]) {
                return true;
            }

            // Element is present on the left side
            if (target < matrix[r][c]) {
                high = mid - 1;

            } else {
                // Element is present on the right side
                low = mid + 1;
            }

        }
        return false;
    }
}