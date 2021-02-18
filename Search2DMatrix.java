// Time Complexity : O(log(n * m)) = O(log n + log m); n = #rows, m = #cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    // Method - 2 : Time Complexity(log n + log m); n = #rows, m = #cols ; Space Complexity O(1)
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int l = 0, h = m - 1;
//
//        while (l <= h) {
//            int r = l + (h - l) / 2;
//
//            if (target >= matrix[r][0] && target <= matrix[r][n-1]) {
//                int arr[] = new int[n];
//                int k = 0;
//                for (int j = 0; j < n; j++) {
//                    arr[k++] = matrix[r][j];
//                }
//                int low = 0;
//                int high = n - 1;
//                while (low <= high) {
//                    int c = low + (high - low) / 2;
//                    if (arr[c] == target) return true;
//                    else if (arr[c] > target) high = c - 1;
//                    else low = c + 1;
//
//                }
//                return false;
//            }
//            else if (target < matrix[r][0]) h = r - 1;
//            else l = r + 1;
//
//        }
//        return false;
    }

}
