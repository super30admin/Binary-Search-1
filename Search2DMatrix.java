// Time Complexity : O(logmn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if(matrix.length == 0 || matrix == null) {
        return false;
      }
        
      // find matrix row and column size
      int m = matrix.length;
      int n = matrix[0].length;
      
      //binary serach to find the specific element
      //considering the matrix as 1 dimensional array
      int low = 0; int high = m*n-1;
      while(low<=high){
        int mid = low+(high-low) /2; // index of the mid
        //use this mid index to get the row and column
        int row = mid/n;
        int column = mid%n;
        if(matrix[row][column] == target) {
          return true;
        } else if (matrix[row][column] < target){
          low = mid+1;
        } else {
          high = mid-1;
        }
      }
      return false;
    }
}