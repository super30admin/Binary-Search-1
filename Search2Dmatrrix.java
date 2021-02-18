-------------------------------------------------------------------------------Approach 1 --------------------------------------------------------------------
  // Time Complexity : O(n*logm) where n is  number of rows, m is no of columns
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It took some time to find which column to apply binary search, but later not much of a problem


// Your code here along with comments explaining your approach
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        //Getting the column length for first row
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
          //if target is less than last value of any column, then that is the last column to apply binary search to.
            if(target<=matrix[i][col-1]){
                return find(matrix[i], target);
            }
        }
        return false;
    }
      
    // Just a binary search for given column in all row
     private boolean find(int nums[], int target){
        int low = 0, high = nums.length-1;
        
        while(low <= high){
            int mid = low+(high-low)/2;
            
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return false;
    }
}

---------------------------------------------------------------- Approach 2(Discussed in class) ----------------------------------------------------------------------
   // Time Complexity : O(log(m*n) where n is  number of rows, m is no of columns
// Space Complexity : O(mn) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It took some time to find which column to apply binary search, but later not much of a problem
  
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int low = 0;
        int high= n*m-1;
        
        // Doing binary search for the entire converted 1d array.
        while(low<=high){
            int mid = low+(high-low)/2;
            
          
            //To convert or trace back to 2d matrix, we have to both modulus and division for row and colum respectively.
            int i = mid/m;
            int j = mid%m;
            
            if(matrix[i][j]==target){
                return true;
            }
            
            else if(matrix[i][j]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}
