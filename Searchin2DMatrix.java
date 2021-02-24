class Solution {
    
    /*
      Time : log( M * N) | total number of elements 
      Space : O(1) 
      Leetcode yes
    */
  
    /*
      Approach :
        1. Assume given 2D array is contiguous and perferm binary search on it.
        2. at each iteration we will get, row = mid/colSize and col = mid % colSize
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null ) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = (m * n ) - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int element = matrix[mid/n][mid%n];
            
            if(element == target){
                return true;
            }else if(element > target){
                high = mid - 1;                
            }else{
                low = mid + 1;
            }
        }
        
        return false;
    }
    
    
    // Another way of implementing Binary Search
    public boolean searchMatrix(int[][] matrix, int target) {
        int high = (matrix.length * matrix[0].length ) - 1;
        return searchBinary(matrix, 0, high, target);
    }
    
    private boolean searchBinary(int[][] matrix, int low, int high, int target){
        
        while(low <= high){
            int mid = low + (high - low) /2 ;
            
            int index1 = mid / matrix[0].length;
            int index2 = mid % matrix[0].length;
            
            if(matrix[index1][index2] == target)
                return true;
            else if(matrix[index1][index2] < target){
                return searchBinary(matrix, mid + 1, high, target);
            }else {
                return searchBinary(matrix, low, high -1 , target);
            }
                        
        }
        
        return false;
    }
}
