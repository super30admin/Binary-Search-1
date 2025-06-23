// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Treat the 2D matrix as a virtual 1D sorted array to perform binary search.
// Convert 1D mid index to 2D using row = mid / n and col = mid % n.
// Apply standard binary search by comparing matrix[row][col] with the target.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Edge case: empty matrix
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            // Convert 1D index to 2D coordinates
            int row = mid / n;
            int column = mid % n;

            // Standard binary search logic
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Target not found
        return false;
    }
}