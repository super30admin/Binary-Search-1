Time Complexity : log n 

Successfull on Leetcode


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
       int x=matrix.length;
        int y=matrix[0].length;
        
        int low = 0;
        int high = x*y-1;
        
        while ( low <= high )
        {
            int mid = low + (high - low ) /2;
            
            int i = mid / y;
            int j = mid % y;
            
            
            
            if ( target == matrix[i][j])
              { 
                return true;
                }
            
            if (  matrix[i][j] <= target)
            {
                System.out.println(matrix[i][j]);
                low = mid + 1;
            }
                
            if (  matrix[i][j] > target)
            {
                high = mid -1 ;
            }
            
                
        
         }
        
        return false ;
    }
}