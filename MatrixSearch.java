/**
 * O(log(n)) time complexity as it takes 2 binary searches to search through the matrix
 * 
 * no additional space was allocated to perform the computation, so O(1)
 */
public class MatrixSearch {
    private int target;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.target = target;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = findRow(matrix, 0, rows-1);
        if(row == -1) {
            return false;
        }
        return binarySearch(matrix, 0, cols-1, row);
    }
    
    private int findRow(int[][] matrix, int l, int r) {
        if( l <= r) {
            int mid = (l+r)/2;
            if ( l == r && matrix[mid][0] <= target || l < r && matrix[mid][0] <= target && target < matrix[mid + 1][0]){
                return mid;
            }
            if (matrix[mid][0] > target){
                return findRow(matrix, l, mid-1);
            }
            return findRow(matrix, mid+1, r);
        }
        return -1;
    }
    
    private boolean binarySearch(int matrix[][], int l, int r, int row) { 
        if( l <= r) {
            int mid = (l+r)/2;
            if (matrix[row][mid] == target){
                return true;
            }
            if (matrix[row][mid] > target){
                return binarySearch(matrix, l, mid-1, row);
            }
            return binarySearch(matrix, mid+1, r, row);
        }
        return false;
    }
}
