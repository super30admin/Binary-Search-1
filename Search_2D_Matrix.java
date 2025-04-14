// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // base case
        if(matrix == null || matrix.length == 0) return false;

        // find lengths
        int m = matrix.length; // no of rows
        int n = matrix[0].length; // no of columns

        int low = 0;
        int high = m * n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            // find the index position in matrix to get the middle element in matrix
            int r = mid / n;
            int c = mid % n;

            // just perform normal binary search
            if(target == matrix[r][c]) { // target found
                return true;
            }
            else if(target > matrix[r][c]) { // if target greater than mid then update the range by moving low to mid + 1 and perform search again
                low = mid + 1;
            }
            else { // if target less than mid then update the range by moving high to mid - 1 and perform search again
                high = mid - 1;
            }
        }

        // if target not found
        return false;
    }
}