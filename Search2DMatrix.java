// Time Complexity : O(log(mn))
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Considering 2D Matrix using Binary Search, calculated the mid and by finding the row and column index of element changed low, high and mid values

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Checking if matrix has value 
        if(matrix.length==0 || matrix==null) 
            return false;
        int rows = matrix.length, columns = matrix[0].length;
        int low = 0, high =(rows*columns)-1, mid;
        while(low <= high) {
            mid = low + (high-low)/2;
            // Columns will be useful to find the row and column index of element
            int rowIndex = mid / columns;
            int columnIndex = mid % columns;
            if(matrix[rowIndex][columnIndex]==target) {
                return true;
            } else if(matrix[rowIndex][columnIndex]>target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return false;        
    }
}
