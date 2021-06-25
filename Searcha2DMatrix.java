// Time Complexity : o(n)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length-1;
        int col = matrix[0].length-1;


        while(row>0 && col>=0 ){

            if(target == matrix[row][col]){
                return true;
            }
            else if(target > matrix[row-1][col]){
                col--;
            }
            else if(target <= matrix[row-1][col]){
                row--;
            }

        }

        for(int i : matrix[row]){

            if(i == target) return true;
        }

        return false;

    }
}
