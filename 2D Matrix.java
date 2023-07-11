// Time Complexity : O(log2(m*n)); where m = number of rows and n = number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null && matrix.length == 0) return false;  //check if the matrix is null or empty
        
        int m = matrix.length;                              //To get number of rows of a matrix
        int n = matrix[0]. length;                          //To get number of columns of a matrix
        
        int low = 0;                                        //Set low at index 0
        int high = m*n -1;                                  //Set high at last index
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            int row = mid / n;                              //to determine mid element's row number in a matrix
            int col = mid % n;                              //to determine mid element's column number in a matrix
            
            if(matrix[row][col] == target) return true;     //check if mid element is the target element
            else if(matrix[row][col] < target){             //if target element exists on right side of mid
                low = mid + 1;
            }else{                                          //if target element exists on right side of mid
                high = mid - 1;
            }
        }
        return false;                                       //if target element is not found
        
    }
}