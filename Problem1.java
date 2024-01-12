//Problem - Search a 2D matrix
//Time Complexity - O(log(m*n) number of rows and column
//Space Complexity - O(1) 
//Code run successfully on Leetcode - Yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = (row * col) - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int r = mid/col; 
            int c = mid%col;
            if(matrix[r][c] == target) return true;
            if(matrix[r][c] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;   
    }
}