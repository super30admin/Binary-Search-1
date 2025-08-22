// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
Consider 2D array as 1D array and calculate low, high and mid element
Convert the mid to get the row and column index by using / and % on column
On the range apply the binary search
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //no. of rows
        int n = matrix[0].length; //no. of columns

        int low = 0;
        int high = m*n - 1;
        int mid;

        while(low<=high) {
            mid = low + (high-low) / 2;
            //Get the row and column index
            int r = mid/n;
            int c = mid%n;
            if (matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false; 
    }
}
