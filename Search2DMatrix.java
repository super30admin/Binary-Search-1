// TC = O(logM*N)
// SC = O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) return false;
        
        int m = matrix.length;          //rows
        int n = matrix[0].length;        //columns
                
        int low = 0; 
        int high = m*n-1;
        
        while (low <= high){
            int mid = low + (high-low)/2;
            int r = mid / n;          //finding the actual row index for mid
            int c = mid % n;          //finding the actual column index for mid
          
            if (matrix[r][c] == target) return true;
            if (matrix[r][c] < target){
                low = mid+1;
            }
            if(matrix[r][c] > target){
                high = mid -1;
            }
        }
            
        return false;
    }
}
