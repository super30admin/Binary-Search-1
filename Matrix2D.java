// Time Complexity : o(n) + o(m)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i =0;
        int j = 0;
        int row = 0;
        int r = matrix[0].length;
        int c = matrix.length;
        for (i =0; i < c; i++ ){
            if(target == matrix[i][0] || target == matrix[i][r-1]){
                return true;
            }
            if (target > matrix[i][0] && target < matrix[i][r-1]){
                row = i;
            } 
        }
        for(j = 0; j <r; j++){
            if (target == matrix[row][j]){
                return true;
            }
        }
        return false;
    }
}