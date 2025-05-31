// Time Complexity : O(m + n), where m = number of rows and n = number of columns
// Space Complexity : O(1) — constant space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :
// I started the search from the top-right corner of the matrix. 
// If the current value is greater than the target, I moved left; otherwise, I moved down.
// This approach leverages the matrix's sorted rows and columns to efficiently locate the target.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int target = 34;
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        Solution sol = new Solution();
        System.out.println(sol.searchMatrix(matrix, target));
    }
}
