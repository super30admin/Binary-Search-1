// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :none

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // init low pointer
        int low= 0;
        // init high pointer
        int high= (matrix.length)*(matrix[0].length)-1;
        // we will be treating the 2d array as a one d array to solve the problem
        
        // Iterate while low <=high
        while (low<=high){
            // find mid element
            int mid= low+(high-low)/2;
            // find the row position of mid by dividing the mid by number of columns
            int row=mid/matrix[0].length;
            // find the column position of the mid element by taking mod of mid by number of column
            int col=mid%matrix[0].length;
            
            // if target is mid element return true
            if(target==matrix[row][col]){
                return true;
            }
            // if target is smaller than high, update high
            if (target<=matrix[row][col]){
                high= mid-1;
            }
            // if target is greater than mid, update low
            if (target>matrix[row][col]){
                low= mid+1;
            }
                
        }
        return false;
    }
    
}