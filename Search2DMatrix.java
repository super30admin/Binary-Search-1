public class Search2DMatrix {
  // Time Complexity is O(m+n) and space complexity is O(1)
  /**
   *
   * We are basically traversing column-wise starting at end of column and using 2
   * pointers to change (decrementing)column if element is ">" else row
   * incrementing if "<".
   * Yes it ran successfully on LC.
   */

  public boolean searchMatrix(int[][] matrix, int target) {

    int row_Idx = 0, col_Idx = matrix[0].length - 1;

    while (row_Idx < matrix.length && col_Idx >= 0) {

      if (matrix[row_Idx][col_Idx] == target) {
        return true;
      } else if (matrix[row_Idx][col_Idx] > target) {

        col_Idx--;
      } else if (matrix[row_Idx][col_Idx] < target) {

        row_Idx++;
      }

    }
    return false;
  }

}

class Main {
  public static void main(String args[]) {
    Search2DMatrix s = new Search2DMatrix();
    int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    boolean result = s.searchMatrix(matrix, 3);
    System.out.println(result);
  }
}