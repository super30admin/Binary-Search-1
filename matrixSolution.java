// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Conversion from matrix to 1-d array, referred to lecture for the code and logic.

class matrixSolution {
    public boolean searchMatrix(int [][] matrix, int target) {

        // if matrix is empty or does not exist
        if(matrix == null || matrix.length == 0)
            return false;
        int m, n;
        m = matrix.length;      // rows
        n = matrix[0].length;   // cols
        
        int low, high, mid;

        low  = 0;       // left most
        high = n*m - 1; // right most 
        
        while(low <= high) {
            mid = low + (high - low) / 2;
            int rows = mid / n;
            int cols = mid % n;
            if (matrix[rows][cols] == target) return true;
            // move left
            else if (matrix[rows][cols] > target) {
                high = mid - 1;
            }
            // move right
            else
                low = mid + 1;
        } 
                
        // Element not found 
        return false;
    }

}