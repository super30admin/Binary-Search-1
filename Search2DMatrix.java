// https://leetcode.com/problems/search-a-2d-matrix/

// Time Complexity : o(log n)
// Space Complexity :o (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length; 
        int colLength = matrix[0].length; 

        int low = 0; 
        int high = rowLength * colLength-1; 

        while(low <= high) {
            int mid = low + (high-low) /2;

            int midElementRow = mid / colLength; 
            int midElementCol = mid % colLength; 

            if(matrix[midElementRow][midElementCol] == target) {
                return true;
            }
            else if(matrix[midElementRow][midElementCol] > target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return false;
    }
}
