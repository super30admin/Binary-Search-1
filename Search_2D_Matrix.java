
// Time Complexity :O(log mn) 
// Space Complexity : O(1)  for push,pop,top,getMin
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope 


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        

      int m = matrix.length;
      int n = matrix[0].length;
      int l = 0, r = m*n -  1;

      while(l<=r) {
         int mid = l + (r-l)/2;
         int row = mid/n;
         int column= mid%n;
         if (matrix[row][column] == target)
          return true;
          else {
          if(matrix[row][column] > target) 
          r= mid-1;
          else 
          l = mid+1;
      }
      }
      return false;

    }
}
