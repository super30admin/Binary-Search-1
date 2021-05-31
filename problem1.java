// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class SearchMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = (rows * cols) - 1;
        
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            int rowIndex = mid / cols;
            int colIndex = mid % cols;
            
            if(matrix[rowIndex][colIndex] == target) return true;
            
            else if(matrix[rowIndex][colIndex] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
         return false;
      }
}

// Approch 2: Step 1: Apply binary search on the first cloumn to find the closet number (row index) to the target. 
             //Step2: Implement another binary serach on the corresponding row to find wether target is present or not. 
// Time Complexity : O(2logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No 
// Any problem you faced while coding this : Yes, Failing for the input matrix = [[1],[3]] and target = 3.

class Solution {
    
    int difference = Integer.MAX_VALUE, targetRowIndex = -1;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = cols-1;
      
    
        if(rows == 1) return binarySearch(matrix[0], target);  // if there is only one row
        else targetRowIndex = findClosestElement(matrix, low, rows-1, target);
        
        return (targetRowIndex != -1) ? binarySearch(matrix[targetRowIndex], target) : false;
      }
    
    private int findClosestElement(int[][] matrix, int low, int high, int target) {
        
        while(low <= high) {
            
            int mid = low + (high - low)/2;
         
            if (Math.abs(matrix[mid][0]-target) < difference) {
                   difference = Math.abs(matrix[mid][0]-target);
                   targetRowIndex = mid;  
               }
              
            if(matrix[mid][0] > target) 
                   high = mid - 1; 
            
            else if(matrix[mid][0] < target) 
                low = mid + 1;
        }
        return targetRowIndex;
    }
    
    private boolean binarySearch(int[] targetRow, int target) {
        
        int low = 0, high = targetRow.length-1;
        
        while(low <= high) {        
            int mid = low + (high - low) / 2;
            
            if(targetRow[mid] == target) return true;
            else if(targetRow[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
    
}
