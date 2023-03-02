// Space Complexity: O(1)
// Time Complexity: O(m + n); worst case it would do (m + n - 2) comparisons which is O(m+n).
// Did this code successfully run on Leetcode : Yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        
        // If target is smaller than smallest or larger than largest, don't search at all
        if (target > matrix[m-1][n-1] || target < matrix[0][0]) {
            return false;
        }

        int row = 0;
        int col = n - 1;

        // While within bounds
        while (row < m && col >= 0) {
            // Target found
            if (target == matrix[row][col]) {
                return true;
            } 
            // Move left
            else if (target < matrix[row][col]) {
                col -= 1;
            } 
            // Move down
            else {
                row += 1;
            }
        }

        return false;
    }

    // Approach 2

    // Time Complexity: O(log(mn))
    // Space Complexity: O(1)
    // Did this code successfully run on Leetcode : Yes
    
    // Think of 2-D array as a flat 1-D array with "m*n" elements in it.
    // Perform binary search on it.

    public boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int midElement = matrix[mid/n][mid%n];
            if (target == midElement) {
                return true;
            } else if (target < midElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}