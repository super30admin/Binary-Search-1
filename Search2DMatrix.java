// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0)
        {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }

}
// Your code here along with comments explaining your approach
