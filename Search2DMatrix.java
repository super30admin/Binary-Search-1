//Time Complexity :O(m + n)
// Space Complexity : constant
// Did this code successfully run on Leetcode :Yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            //we'll check each row if target falls inside the row range
            if (matrix[i][j] > target) {
                i --;
            }
            else if (matrix[i][j] < target) {
                j ++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

