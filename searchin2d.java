// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : coverting 1d index to 2d


// Your code here along with comments explaining your approach in three sentences only
// we can consider the 2d array as a 1d array and perform binary search. we need to convert the index of the 1d
// array to 2d array and compare it with target.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int low=0;
      if(matrix == null) return false;
      int row = matrix.length;
      int col = matrix[0].length;
      int high = (row * col) -1 ;
      while(low <= high)
      {
        int mid = low + (high-low)/2;
        int r = mid/col;
        int c = mid%col;
        if(matrix[r][c]== target) return true;
        else if(matrix[r][c] > target) 
            high = mid-1;
        else 
            low = mid+1;
      }
      return false;
    }
}