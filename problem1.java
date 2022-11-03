class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int row = matrix.length; 
        int col = matrix[0].length;
        //outer bounderies
        int low = 0;
        int high = row * col -1;
        
        while(low <=high){
            int mid = low + (high - low )/2; // to prevent integer overflow
            int curr_row = mid /col; 
            int curr_col = mid%col;
            if(matrix[curr_row][curr_col] == target){
                return true;
            }
            
            else if(target > matrix[curr_row][curr_col]){
                low = mid +1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
}
