//time complexity is : 0(logn) and space complexity is 0(1)
class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int totalRow = matrix.length;
    int totalCol = matrix[0].length;

    int start = 0;
    int end = totalRow * totalCol - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      int row = mid / totalCol;
      int col = mid % totalCol;

      if (matrix[row][col] == target) return true; else if (
        target < matrix[row][col]
      ) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    // System.out.println(col);
    return false;
  }
}
