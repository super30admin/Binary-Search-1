// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        int low = 0;
        int high = totalRows * totalCols - 1;

        while (low <= high) {
            int mid = low + (high -low) / 2;
            int i = mid / totalCols;
            int j = mid % totalCols;

            if(matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}
