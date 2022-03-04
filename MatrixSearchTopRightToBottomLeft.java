public class MatrixSearchTopRightToBottomLeft {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int row = 0;
        int col = cols-1;
        
        while (row < rows && col >= 0) {
            
            if(matrix[row][col] == target) {
                return true;
            }
            if(target < matrix[row][col]) {
                col = col-1;
            }
            else {
                row = row + 1;
            }
        }
        return false;
    }    
}
