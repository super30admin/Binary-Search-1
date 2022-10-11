// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach.
// Consider the flattening the array virtually since the elements are sorted. Use the indices and
// do a binary search.


class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int tR = matrix.length;
    int tC = matrix[0].length;
    int start = 0, end = tR * tC - 1;
    while(start <= end) {
      int mid = start + (end-start)/2;
      System.out.println(mid);
      int r = mid/tC;
      int c = mid%tC;
      if(matrix[r][c] == target)
        return true;
      else if(matrix[r][c] > target)
        end = mid - 1;
      else
        start = mid + 1;
    }

    return false;

  }
}