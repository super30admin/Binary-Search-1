// Time Complexity : O(log(m*n))
// Space Complexity : 0
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out how to calculate row and column indexes

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        
        // set high pointer to total number of elements in 2d matrix - 1
        int high = n * m - 1;
        
        while (low <= high) {
            
            int mid = (low+high) / 2;
            
            // Get row and column indexes
            int i = mid / m;
            int j = mid % m;
            
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            
        }
        
        return false;
        
    }
}