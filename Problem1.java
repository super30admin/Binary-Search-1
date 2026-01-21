//Search a 2D Matrix https://leetcode.com/problems/search-a-2d-matrix/

// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -
class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;

    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0;
    int high = m * n - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int r = mid / n;
      int c = mid % n;
      if (matrix[r][c] == target) return true; else if (matrix[r][c] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return false;
  }
}

class Problem1 {

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

    System.out.println(sol.searchMatrix(matrix, 34));
    System.out.println(sol.searchMatrix(matrix, 33));
  }
}
