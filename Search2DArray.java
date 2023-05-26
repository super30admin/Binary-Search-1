// Time Complexity :O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0, col = matrix[0].length - 1;// Calculating the row and column length of the matrix
    while(row < matrix.length && col >= 0) {//Manupilating the focus based on the value of the target by comparing with the last element in the matrix on the row
        if(matrix[row][col] == target)
          return true;
        else if(matrix[row][col] > target)
          col --;
        else if(matrix[row][col] < target)
          row ++;
      }
      return false;
        

        
        
    }
}
