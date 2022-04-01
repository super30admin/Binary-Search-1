// Time Complexity : O(log(m*n)) because we are treating 2D matrix as flattened 1D array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix == null){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n -1; // last index of the flattened array

        while(low <= high){

            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }

        return false;
    }
}
