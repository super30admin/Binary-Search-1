// In this proble, given a 2D matrix of m rows and n cols (say), then we need to search for given target. If it exists we return true. Else, we return false
// In this solution, we treat the matrix as a 1D array of length m*n - last index being m*n-1. 
// After calculating mid, row index would be mid / n whil col index would be mid % n
// Time complexity : O(log m*n)
// Space complexity : O(1) <-- constant as we only use variables and not create any additional datastructure for storage

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        int mid;
        int row;
        int col;
        while(low<=high) {
            mid = low + (high - low) / 2;
            row = mid / n;
            col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }
            else  
            { 
                if(matrix[row][col] < target)
                {
                // Check left side
                low = mid + 1;
                }
                else {
                // Check right side
                high = mid - 1;
                }
            }
        }
        return false;
    }
}
