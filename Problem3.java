// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Search in 2D matrix
// - Treats the 2D matrix as a single sorted 1D array and applies binary search.
// - Converts the 1D middle index back to row and column coordinates using division and modulo operations.
// - Returns true if the target is found; otherwise returns false after the search space is exhausted.



class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0, high = rows * cols - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int midRow = mid / cols;
            int midColumn = mid % cols;

            if(matrix[midRow][midColumn] == target) {
                return true;
            }
            if(target < matrix[midRow][midColumn]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}