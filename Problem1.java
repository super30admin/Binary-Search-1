// Time Complexity
// With bruteforce solution: O(m*n)
// With Binary search Optimization: O(Log m + Log n)
// Where n = number of elements in array.
// Space Complexity
// With bruteforce solution: O(1)
// With Binary search Optimization: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) // Check for the empty matrix scenario
            return false;

        int m = matrix.length; // Calculate number of rows
        int n = matrix[0].length; // Calculate number of columns
        int low = 0; // first index if converted to 1-D array
        int high = m * n - 1; // last index if converted to 1-D array
        while (low <= high) { // Loop until low becomes greater than high
            int mid = low + (high - low) / 2; // Mid point of the array

            int r = mid / n; // Calculate the row index for midpoint
            int c = mid % n; // Calculate the column index for midpoint

            if (matrix[r][c] == target) // Check if the mid is our target, if yes return true
                return true;

            if (matrix[r][c] > target) { // Check if the target lies before mid, if yes move high pointer to the index
                                         // before mid
                high = mid - 1;
            } else { // As target is after mid, if yes move low pointer to the index after mid
                low = mid + 1;
            }
        }
        return false; // Return false if target not found
    }

}