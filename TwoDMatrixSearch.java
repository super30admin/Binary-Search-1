public class TwoDMatrixSearch {
  /*
  Approach - 1:

  Consider the 2 D Matrix as a 1-D array and find the target as normal Binary search. O(Log(m * n)) comoplexity

  We can make the 2-D matrix into a 1-D matrix and just perform a normal Binary search.
    
    Just assume that you are joining rows one after another to make one long 1-D array.
    
    The 1-D array length would be: m * n
    
    How do we pick an element from matrix corresponding to the index on 1-D array.
    
    The index would be at the following
    row: index / (no. of columns)
    column: (index % (no. of columns))
  */

  /*
  Time Complexity: O(log(m * n))
  Space Complexity: O(1)
  Did this code successfully run on Leetcode : Yes
  Any problem you faced while coding this : No 
  */

  public boolean searchMatrix(int[][] matrix, int target) {
        
    int left = 0, right = matrix.length * matrix[0].length-1;
    
    while(left <= right){
        int mid = left + (right - left)/2;
        
        // find index on 2D matrix corresponding to mid
        int row = mid / matrix[0].length;
        int col = mid % matrix[0].length;
        
        if(matrix[row][col] == target){
            return true;
        } else if(matrix[row][col] < target){
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return false;
  }
}
