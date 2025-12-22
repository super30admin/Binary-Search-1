/*Time Complexity : O(M*N) where M is number of rows and N is number of columns
     Space Complexity : O(1), no additional space needed
     Did this code successfully run on Leetcode : Yes
     Any problem you faced while coding this : No

     Your code here along with comments explaining your approach in three sentences only
     First do binary search on the first column to identify which row the target is in. Do another binary search on
     the particular row to find the column. if the target doesn't exist return false;*/
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return matrix[0][0] == target;
        }

        int low = 0;
        int high = row - 1;
        int requiredRow = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] == target || matrix[mid][col - 1] == target) {
                return true;
            }
            if (matrix[mid][0] < target && target < matrix[mid][col - 1]) {
                requiredRow = mid;
                break;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = col - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[requiredRow][mid] == target) {
                return true;
            } else if (target < matrix[requiredRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}