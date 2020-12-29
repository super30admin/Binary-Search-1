// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had some difficulty in calculating the row, col values for the mid element

// Notes: The 2D array is treated as an array, performing binary search while calculating the row, col values for the mid element

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = m * n - 1;
        
        while( low <= high){
            int mid = low + (high - low)/2;
            
            int row = mid / n;
            int col = mid % n;
            
            if(matrix[row][col] == target){
                return true;
            } else if(target <= matrix[row][col]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return false;
    }
}
