// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

public class TwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        // check whether matrix is null or not
        if( matrix == null || matrix.length == 0 ) return false;

        // count row and length of matrix
        int matrixLength = matrix.length;
        int rowLength = matrix[0].length;

        // initialize high and low point
        int low = 0;
        int high = matrixLength * rowLength - 1;

        while( low <= high){
            // we used (high - low) instead of high only to prevent integer overflow
            int midPoint = low + (high - low) / 2;
            int row = midPoint / rowLength;
            int column = midPoint % rowLength;

            // if target is same as matrix's row and column return true
            if(matrix[row][column] == target){
                return true;
            }
            else if(target > matrix[row][column]){
                // increase the low to search right side of the matrix
                low = midPoint + 1;
            }
            else{
                // decrease the high to search left side of the matrix
                high = midPoint -1;
            }
        }
        return false;
    }
}
