// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class SearchIn2dArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m* n - 1; // Conceptually converting this into single dimension array
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            //calculating actual row and column numbers based on our conceptual array index
            int row = mid / n; 
            int column = mid % n;
            
            if(matrix[row][column] == target) return true;
            
            if(target < matrix[row][column]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
