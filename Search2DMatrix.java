// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We perform binary search on the virtual 1D array (index from 0 to m*n - 1).
// We map the 1D index to 2D using row = index / n and col = index % n to access actual elements.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Matrix size
        int m = matrix.length;
        int n = matrix[0].length;

        // Low and high pointers for binary search
        int low = 0;
        int high = m * n - 1;

        // Binary search on virtual 1D array
        while (low <= high) {
            // Find mid
            int mid = low + (high - low) / 2;

            // Convert 1D mid to 2D indices
            int r = mid / n;
            int c = mid % n;

            // If target found; return true
            if (matrix[r][c] == target) return true;

            // If target is smaller, move left; else move right
            if (target < matrix[r][c]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // Target not found
        return false;
    }
}
