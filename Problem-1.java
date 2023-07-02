// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows*columns -1;

        while(low<=high) {
            int mid = low + (high-low)/2;
            int r = mid/columns;
            int c = mid%columns;
            if(matrix[r][c] == target) {
                return true;
            }
            else if(matrix[r][c]>target) {
                //left search
                high = mid -1;
            }
            else {
                //right search
                low = mid + 1;
            }
        }

        return false;
    }
}