class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m,i,j=0;
        m=matrix.length;
        for(i=0;i<m;i++){
            
            if(matrix[i][j]>target){ 
                break;
            }
            if(matrix[i][j]==target){
            return true;
            }
        }
        i--;
        if(i==-1){
           i=0;
        }
        for(j=0;j<matrix[i].length;j++){
            if(matrix[i][j]==target){
                return true;
            }
            
        }
        return false;
    }
}