class ArrayMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0) return false;
        
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = (m*n) - 1;
        
        while (low <= high) {
            
            int mid = low + (high - low) /2;
            int row_index = mid / n;
            int column_index = mid % n;
            
            if (matrix [row_index][column_index] > target) {
                
                high = mid - 1;
                
            } else if (matrix [row_index][column_index] < target) {
                
                low = mid + 1;
                
            } else if (matrix[row_index][column_index] == target) {
                
                return true;
                
            } else {
                return false;
            }
            
        } 
        return false;
        
    }
    
}