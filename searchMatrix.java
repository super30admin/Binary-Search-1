// Time Complexity : O( m + logn) m is the row and n is the column length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // check base cases- if the matrix is empty return false;
        if (matrix.length == 0 || matrix == null)
            return false;

        // get the row and column of matrix
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;

        // find the row in which the traget element might be present
        // compare the 1st adn last element of every row
        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1])
                row = i;
        }

        int start = 0;
        int end = n - 1;

        // do binary search for the selected row and return the result;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] == target)
                return true;

            if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;

    }
}

// Time Complexity : O(logmn) optimal solution
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        // take start as 0 and end as the last element in the matrix
        int start = 0;
        int end = (m * n) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // calculate row and column for the index generated using the index
            int row = mid / n;
            int col = mid % n;

            // same as bimary search
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}