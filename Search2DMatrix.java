// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // check if input data is incorrect
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // start from top-right of the matrix
        // and go to the left-and-down
        // while indexes in bounds of m,n or don't find target
        int rowIndex = 0;
        int columnIndex = matrix[0].length - 1;
        while (columnIndex >= 0 && rowIndex <= matrix.length - 1) {
            int currentValue = matrix[rowIndex][columnIndex];
            if (currentValue == target) {
                return true;
            }

            if (currentValue < target) {
                rowIndex++;
            } else {
                columnIndex--;
            }
        }

        return false;
    }
}