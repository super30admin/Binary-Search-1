//Time Complexity - O(log(m*n)) where m is number of row and n is number of columns
//Space Complexity - O(1) Not using any extra space.

// Implemented searchMatrix using Binary search.
// Assumed the 2d array into 1d array as it stated that the last element of each row is less than
// first element of next row. The row and column of the mid is found by dividing and mod of n.
public class Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m * n) - 1;
        while(low <= high) {
            int mid = low +(high - low) / 2; // prevent overflow
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) {
                return true;
            } else if(target < matrix[row][col]) {
                high = mid -  1;

            } else {
                low = mid + 1;
            }

        }
        return false;
    }
}
