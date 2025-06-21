// Time Complexity : O(log(m*n)) // Because we consider the 2D as a virtual 1D with size m*n
// Space Complexity : O(1) 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m * n) - 1;
        
        while (low <= high) {
            // mid becomes the index in 1D array
            int mid = low + (high - low) / 2;
            // mid / n gives the row and mid % n gives column.
            int midValue = matrix[mid / n][mid % n];

            if (target == midValue) {
                return true;
            }

            if (target < midValue) {
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return false;
    }
}