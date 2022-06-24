class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        
        while (firstRow <= lastRow) {
            int middle = firstRow + (lastRow - firstRow) / 2;
            
            if (target <= matrix[middle][matrix[middle].length - 1] && target >= matrix[middle][0]) {
                
                int left = 0;
                int right = matrix[middle].length - 1;
                int mid = 0;
                    
                while (left <= right) {
                    mid = left + (right - left) / 2;
                    if (target == matrix[middle][mid]) {
                        return true;
                    } else if (target < matrix[middle][mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                
                return false;
            } else if (target < matrix[middle][0]) {
                lastRow = middle - 1;
            } else {
                firstRow = middle + 1;
            }
        }
        
        return false;
    }
}