// Time Complexity : O(m + logn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length != 0){
            int rowCount = matrix.length;
            int colCount = matrix[0].length;
            
            int matMidPoint = colCount/2;
        for(int i=0; i<rowCount; i++){
            if(matrix[i][colCount-1] == target){
                return true;
            }
            else if (matrix[i][colCount-1] > target){                
                if(matrix[i][matMidPoint] == target){
                    return true;
                }
                else if(target < matrix[i][matMidPoint]){
                    for(int j = 0; j < matMidPoint; j++){
                        if(matrix[i][j] == target){
                            return true;
                        }
                    }
                }
                else if(target > matrix[i][matMidPoint]){
                    for(int j = matMidPoint; j < colCount-1; j++){
                        if(matrix[i][j] == target){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
            
        }
        else{
            return false;
        }
    }
}