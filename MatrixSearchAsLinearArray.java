public class MatrixSearchAsLinearArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows*cols - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            int row = mid/cols;
            int col = mid%cols;
            int midElement = matrix[row][col];
            
            if(midElement == target) {
                return true;
            }
            if(target < midElement) {
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    } 
}
