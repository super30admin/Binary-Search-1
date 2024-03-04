// Time Complexity : O(log(m*n)), where m and n are dimensions of matrix
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach in three sentences only

public class TwoDMatrix {
// Approach # 2
    // Time Complexity : O(log(m*n)), where m and n are dimensions of matrix
    // Space Complexity : O(1), no extra space used
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        // Idea: convert this 2D array to a 1D array
        int m = matrix.length; // number of row
        int n = matrix[0].length; // number of column
        int length = m * n;

        int low = 0;
        int high = length - 1;

        while(high >= low){
            int mid = low + (high - low)/2; // calculate mid
            int row = mid/n; // to get the row, as we have converted to 1d array
            int column = mid%n; // to get the column, as we have converted to 1d array

            if(matrix[row][column] == target) {
                return true;
            } else if(matrix[row][column] > target) {
                // target is smaller than mid, then go left
                high = mid - 1;
            } else {
                // target is greater than element at mid, the go right
                low = mid + 1;
            }
        }
        return false;
    }

// Approach # 1
    // Time Complexity : O(m+n), where m and n are dimensions of matrix
    // Space Complexity : O(1), no extra space used
    public boolean searchMatrix(int[][] matrix, int target) {
        // check for null
        if(matrix.length == 0)
            return false;
        // Idea: start from any side, say m-1,0 and come downwards until we find number greater than target.
        // If number found is greater than traget then go one step up and go side

        // length of matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // i and j would be the indexes we would be using to traverse the matrix
        int i = m-1; // start i from last element of first row
        int j = 0;

        while(i > -1 && i < m && j > -1 && j < n) {
            // we need to traverse matrix until we reach bounderies

            // check if we found the target
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] < target) {
                // target is greater than matrix[i][j]
                // go down
                j++;

            } else {
                // target is smaller than matrix[i][j]
                // go one step side
                i--;
            }
        }
        return false;
    }

}