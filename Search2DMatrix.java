// Time Complexity : O(logmn) => total elements in the matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// Made use of the binary search on the matrix
// Calculated the row number and column number as r = index/n and c = index % n

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / matrix[0].length;
            int c = mid % matrix[0].length;
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;
    }
}