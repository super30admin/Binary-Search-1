// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Decide range 0 to no of elements, use mathematical formulae to find a pivot index using / and %.


public class Search2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}