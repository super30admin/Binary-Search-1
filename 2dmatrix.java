class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix.length* matrix.length[0]) - 1;
        
        while(left<=right){
            int mid = left + ((right-left)/2);
            
            int row = mid / matrix.length[0];
            int column = mid / matrix.length[0];
            
            if(target == matrix[row][column]){
                return true;
            }
            
            if(target > matrix[row][column]){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        
    return false;
        
    }
}
