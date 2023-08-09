// Time Complexity : O(log (m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int high = row * col - 1;
        int mid = 0;
        int mid_row = 0;
        int mid_col = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            mid_row = mid / col;
            mid_col = mid % col;
            if(matrix[mid_row][mid_col]==target) {
                return true;
            } else if(target<matrix[mid_row][mid_col]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
