// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class matrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Check for null or empty matrix
        if(matrix == null || matrix.length == 0){
            return false;
        }
        // Initialize low and high pointers
        int low = 0;
        int high = m * n - 1;

        // Get the number of rows and number of columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;


        while(low <= high){
            // find mid
            int mid = low + (high - low) / 2;

            // get the row and column number of mid
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target)
            {
                // if mid is the element we are looking for
                return true;
            } else if(matrix[row][col] < target){
                // if element exists on right side of mid
                low = mid + 1;
            } else {
                // if element exists on left side of mid
                high = mid - 1;
            }
        }
        return false;
    }
}