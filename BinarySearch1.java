// search a 2d matrix

// Time-Complexity- O(log(mn))
// Space Complexity-O(1)
// passed test cases on leetcode-yes
// faced problem-no


class BinarySearch1 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length; // rows
    int n = matrix[0].length; // columns

    int j = 0;
    int rowFound = 0;
    // finding the row in which the target element lies
    for (int i = 0; i < m; i++) {
      if (matrix[i][j] <= target && matrix[i][n - 1] >= target) {
        rowFound = i;
        break;
      }
    }

    int[] row = new int[n - 1];
    row = matrix[rowFound];
    // System.out.println("row found was "+rowFound);

    int result = bSearch(row, 0, row.length - 1, target);

    if (result == -1) return false;
    else return true;
  }

  static int bSearch(int arr[], int low, int high, int element) {
    if (high >= low) {
      int mid = ((low + high) / 2);
      if (arr[mid] == element) return mid + 1;
      if (arr[mid] > element) return bSearch(arr, low, mid - 1, element);
      else if (arr[mid] < element) return bSearch(arr, mid + 1, high, element);
    }

    return -1;
  }
}
