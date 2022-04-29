//SC: O(1)
//TC: O(log m + log n) 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int lowIndex = 0;
        int highIndex = (m*n)- 1;
        
        while(lowIndex <= highIndex){
            int mid = (lowIndex + (highIndex - lowIndex) / 2 );
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target) {
                return true;
                
            } else if(matrix[r][c] > target){
                highIndex = mid - 1;
            } else {
                lowIndex = mid + 1;
            }
        }
        
        return false;
    }
}