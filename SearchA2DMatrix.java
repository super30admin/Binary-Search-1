// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchA2DMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
         
        int row = matrix.length;
        int col = matrix[0].length;
        
        int left =0;
        int right = row*col-1;
       
        // make it to 1D array and then convert the middle index into row and column using division and modulo 
        // and finally apply binary search to check whether the target exists in the matrix.
        while(left <= right){
           int mid = left+(right-left)/2;
           int r = mid/col;
           int c = mid%col;
        
           if(matrix[r][c] == target) return true;

           else if(matrix[r][c] < target){
               left = mid + 1;
           }else{
               right = mid - 1;
           }
        }

        return false;
   }
}