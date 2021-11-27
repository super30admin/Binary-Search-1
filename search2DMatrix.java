// Time Complexity : O(logn)
// Space Complexity : O(1)
public class search2Dmatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // rows = rows * col/ col;
        // if you flatten this array, you can find the row number by dividing it by
        // n & col number by % it by n

        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2; // to avoid integer overflow
            // after getting the mid, divide it by n to find row index & % n to find col
            // //index
            int row = mid / n;
            int col = mid % n;
            if (target == matrix[row][col]) {
                return true;
            }
            if (target <= matrix[row][col]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;

    }
}
