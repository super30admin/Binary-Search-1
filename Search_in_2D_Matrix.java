
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int low = 0;
        int high = (rows * cols) - 1;
        
        while (low <= high){
            int mid = low + (high-low)/2;
            int row = mid / cols;
            int col = mid % cols;
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
