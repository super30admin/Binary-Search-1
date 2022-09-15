// Time Complexity : O(log mn) - m is # of rows and n is # of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //check if the given matrix is empty.
        if(matrix == null || matrix.length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        //to get max number of elements in matrix.
        int h = row*col -1;

        while(l <= h){
            //find mid
            int m = l+(h-l)/2;

            //to get row number of mid element from mid by dividing, mid by # of columns in actual matrix.
            int r = m/col;
            //to get column number of mid element from mid by taking mof of mid by # pf columns of actual matrix.
            int c = m%col;

            //check if target is equal to mid element in matrix.
            if(target == matrix[r][c]) {
                return true;
            }
            //check if target is less than mid element found.
            if(target < matrix[r][c]){
                h = m-1;
            }//if target is greater than mid element.
            else {
                l = m+1;
            }
        }
        return false;
    }
}
