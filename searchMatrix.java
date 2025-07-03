// Time Complexity :O(log(m*n))
// Space Complexity :O(1)
/*Approach:
Apply binary search by treating the 2D matrix as a flattened 1D sorted array.
Map 1D mid index to 2D (row, column) to compare with target.
Adjust low/high pointers based on comparison to efficiently search.*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;// nothing to search as matrix doesnt contain any elements
        }
        int m = matrix.length;// number of rows
        int n = matrix[0].length;// number of columns
        int low = 0; // Start index for binary search
        int high = m * n - 1;// End index for binary search
        while (low <= high) {// Binary search loop over the virtual 1D array
            int mid = low + (high - low) / 2;// to prevent integer overflow
            // Convert mid index to 2D matrix indices (row, column)
            int row = mid / n;// each row has n columns; dividing gives which row the index falls in
            int column = mid % n;// remainder gives position within that row
            if (matrix[row][column] == target) {
                return true;// // If mid element matches the target, returning true
            } else if (target < matrix[row][column]) { // If target is smaller than mid element target must be in the
                                                       // left half, so we move high pointer left.
                high = mid - 1;
            } else {// If target is larger than mid element target must be in the right half, so we
                    // move low pointer right.
                low = mid + 1;
            }
        }
        return false;// if loop completes, target is not present in matrix, returning false
    }
}