/**** Method 1 ****/
//Time Complexity: O(n^2)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// Take two loops and traverse all the elements in the array,and return true if it is found else false.

/**** Method 2 ****/
//Time Complexity: O(n+logn) ~ O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// As the array is sorted, traverse all the columns and check in which column may the target present, then do Binary search.

/**** Method 3 ****/
//Time Complexity: O(log(n*m))
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// The idea is to convert the 2D array to 1D array and do Binary Search on it. But rather using using extra space we calculate mid imaging 1D array but the value at mid are found out by using i/m for row and i%m for column.

/**** Method 1 ****/
// public class _74_Search_a_2D_Matrix {

//     public boolean searchMatrix(int[][] matrix, int target) {

//         for(int i =0 ;i<matrix.length;i++){
//             for(int j = 0; j<matrix[i].length;j++){
//                 if(matrix[i][j] == target){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

// }

/**** Method 2 ****/
// public class _74_Search_a_2D_Matrix {

//   public boolean searchMatrix(int[][] matrix, int target) {
//     for (int i = 0; i < matrix.length; i++) {
//       if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
//         return BS(matrix[i], target);
//       }
//     }
//     return false;
//   }

//   private boolean BS(int arr[], int target) {
//     int lo = 0;
//     int hi = arr.length - 1;

//     while (lo <= hi) {
//       int mid = lo + (hi - lo) / 2;

//       if (arr[mid] == target) {
//         return true;
//       } else if (arr[mid] < target) {
//         lo = mid + 1;
//       } else {
//         hi = mid - 1;
//       }
//     }

//     return false;
//   }
// }

/**** Method 3 ****/
public class _74_Search_a_2D_Matrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    int lo = 0;
    int hi = n * m - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int i = mid / m;
      int j = mid % m;

      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return false;
  }
}
