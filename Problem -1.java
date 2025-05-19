// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Edge case if null matrix
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length; // row
        int n = matrix[0].length; // col

        // Treat 2D matrix as a  1D sorted arrat from index 0 to m*n -1
        int low = 0;
        int high = m *n -1;

        while (low <= high){
            int mid = low + (high - low)/2;

            //Convert 1D indec to 2D coordincate
            int r = mid /n; // Row index
            int c = mid%n;  // col index

            if(matrix [r][c] == target) return true;
            else if (matrix[r][c] > target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return false;
    }
}