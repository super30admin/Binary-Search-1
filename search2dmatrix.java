// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //we can consider the whole matrix to be linearly sorted and try to implement binary search on the 1d array
      //  TC: O(log mn)
      //  SC: O(1)  
        
        
        if(matrix == null || matrix.length == 0)
            return false;
        
        int m = matrix.length, n = matrix[0].length;
        
        int low = 0, high = m * n - 1, r = 0, c = 0;
        
        while(low <= high){
            
            int mid = (low+high)/2;
            r = mid / n;
            c = mid % n;
                
            
            if(matrix[r][c] > target){
                high = mid - 1;
            }else if(matrix[r][c] < target){
                low = mid + 1;
            }else{
                return true;
            }
            
        }
        
        return false;
    }
}