// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Idea is to assume 2D matrix as plain 1D array and selecting low and high pointers and performing binary search
//on row and columns.
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = 0;
        int high = r*c - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = mid / c;
            int col = mid % c;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}
