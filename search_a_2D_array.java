// Space Complexity: O(1)
// Time Complexity: O(m + n); worst case it would do (m + n - 2) comparisons which is O(m+n).
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
}