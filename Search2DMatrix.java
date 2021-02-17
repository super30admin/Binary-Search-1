class Search2DMatrix {

    // Time Complexity: O(log r + log c)
    // where r -> no. of rows and c -> no. of columns in the matrix

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        
        int firstCol = 0;
        int lastCol = matrix[0].length - 1;
        
        int mid;

        while(firstRow < lastRow){
            mid = firstRow + (lastRow - firstRow)/2;
            if(matrix[mid][lastCol] < target)
                firstRow = mid + 1;
            else if(matrix[mid][firstCol] > target)
                lastRow = mid - 1;
            else{
                firstRow = mid;
                break;
            }
        }
        
        while(firstCol <= lastCol){
            mid = firstCol + (lastCol - firstCol)/2;
            if(matrix[firstRow][mid] == target)
                return true;
            else if(matrix[firstRow][mid] > target)
                lastCol = mid - 1;
            else
                firstCol = mid + 1;
        }
        
        return false;
    }
}