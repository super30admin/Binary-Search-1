class Solution {
	
// Brute Force Approach
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i =0; i<matrix.length;i=i+1){
            for(int j=0;j<matrix[i].length;j=j+1){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
