class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
      
        int low = 0;
        int high = m*n -1;
      
        return matrixBS(matrix,low,high,target);
    }
    
    public boolean matrixBS(int[][] matrix, int low, int high, int target){
      int n = matrix.length;
        int m = matrix[0].length;
        int mid = low+(high-low)/2;
      
        
      while(low <= high){
        mid = low+(high-low)/2;
        int i = mid / m;
        int j = mid % m;
        if(target == matrix[i][j]){
          return true;
        }
        if(target > matrix[i][j]){
            low = mid + 1;
        }else{
          high = mid - 1;
        }
      }
       
      return false;
      
    }
}
