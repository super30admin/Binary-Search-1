class Solution {
    // Time Complexity : O(log mn) (m - no of rows, n - no of cols in the matrix)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach 1 - Searching the entire matrix by taking it as a single 1-d array
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int low = 0;
        int high = r * c - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int m = mid / c;
            int n = mid % c;

            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    //Approach 2 - Searching the right row by performing binary search on first col of each row. If no such row is found
    //return false; Then perform Binary search on that row to find the target element.
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = r - 1;
        int row = -1; //take row as -1 initially

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target && matrix[mid][c - 1] >= target) {
                row = mid;
                break;
            } else if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (row == -1) {
            return false;
        }
        int low1 = 0;
        int high1 = c - 1;

        while (low1 <= high1) {
            int mid1 = low1 + (high1 - low1) / 2;
            if (matrix[row][mid1] == target) {
                return true;
            } else if (matrix[row][mid1] > target) {
                high1 = mid1 - 1;
            } else {
                low1 = mid1 + 1;
            }
        }
        return false;
    }
}