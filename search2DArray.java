public class search2DArray {
    /** Time Complexity : O(log(m*n))
     Space Complexity : O(1)
     Did this code successfully run on Leetcode : Yes
     Any problem you faced while coding this : No


     Your code here along with comments explaining your approach in three sentences only **/
    public boolean searchMatrix(int[][] matrix, int target) {
        //These are the rows and columns of the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        //For Binary Search:
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;

    }
}
