// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MatrixSearchSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        //get rows and cols length
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        //initilize low and high for binary search
        int low = 0;
        int high = (rows * cols) - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            //Calculating row and col using mid
            int row = mid / cols;
            int col = mid % cols;
            if(matrix[row][col] == target) {
                return true;
            } else if(target > matrix[row][col] ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}