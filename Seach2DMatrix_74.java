// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

=

/* brutforce Time Complexity = O(m*n) , Space Complexity : O(1)
 * if we create one single array it will be O(mn+lognm);
 */


// Your code here along with comments explaining your approach
class Seach2DMatrix_74 {
    
    public boolean searchMatrix(int[][] matrix, int target) {
 
        int m = matrix.length;
        int n = matrix[0].length;
        
        int high = m*n - 1; // to get last index of 2d array assuming single sorted array
        int low = 0;
        
        while(low <= high){
                
            int mid = low + ( high - low) /2 ;
      
            // getting row and column value based on chunk (column size) we have for each row.
            int i = mid / n;
            int j = mid % n;
           
            if(matrix[i][j] == target){
                return true;
            } else if ( matrix[i][j] > target){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        
        return false;
        
    }
}