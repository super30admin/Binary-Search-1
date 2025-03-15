// Time Complexity :O(log(rows*columns))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Approach:Input matrix is treated as flattened sorted 1D array.
// Middle elements of the matrix are accessed using row(i) and column(j) calculations.
// Search space is adjusted until the target is found.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int l=0;
        int r=rows*cols-1;
        while(l<=r){
            int m=l+(r-l)/2;
            int i=m/cols,j=m%cols;
            if(matrix[i][j]==target){return true;}
            else if(matrix[i][j]>target){r=m-1;}
            else{l=m+1;}
        }
        return false;
    }
}