// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = (rows * cols) - 1;
        int mid;
        while(start<=end){
            mid = start + (end - start)/2;
            int row = mid / cols;
            int col = mid % cols;
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] > target){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return false;
    }
}