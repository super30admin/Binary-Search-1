// This file contains two contains two codes written in two different ways The first is optimized in terms of space than the second one.

// Time Complexity :
//      SearchMatrix = O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
 
 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if( matrix == null && matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = m * n -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            int row = mid / n;
            int column = mid % n;
            if(matrix[row][column] == target) return true;
            else if(matrix[row][column] < target) 
                low = mid + 1;
            else if(matrix[row][column] > target) 
                high = mid - 1;
        }
        return false;
                         
    }
} 



class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        if( matrix == null && matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        int low = 0;
        int high = m - 1;
        int mid = 0;
        int ExpectedRow = 0;
      
      
        while(low <= high) {  
            
             mid  = low + (high - low)/2; 
             if(matrix[mid][n - 1] == target) 
                return true; 
             else if (matrix[mid][n - 1] < target) {
                 low = mid + 1;
             } else if (matrix[mid][n - 1] > target && matrix[mid][0] <= target) {
                 ExpectedRow = mid;
                 break;
             } else if(matrix[mid][n - 1] > target && matrix[mid][0] > target)  {
                 high = mid - 1;
             }      
        }
        
       
        low = 0;
        high = n-1;
        
        while(low <= high) {
            
            mid  = low + (high - low)/2;
            
             if(matrix[ExpectedRow][mid] == target) 
                return true; 
             else if (matrix[ExpectedRow][mid] < target) {
                 low = mid + 1;
             } else if (matrix[ExpectedRow][mid] > target) {
                 high = mid -1;
             }              
            
        }
        return false;          
    }
}