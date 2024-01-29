// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0) {
            return false;
        }

        int matRow = matrix.length;
        int matCol = matrix[0].length;
        int low = 0, high = (matRow * matCol) - 1;
        while(low <= high) {
            int mid = low +(high - low) / 2;
            int row = mid/ matCol;
            int col = mid % matCol;

            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
