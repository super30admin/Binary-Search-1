// Time Complexity : O(Logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //checking if matrix is given or not and if its length is 0(base case)
        if(matrix==null||matrix.length==0)
            return false;
        //no of rows and columns
        int rows=matrix.length;
        int cols=matrix[0].length;
        //lower and higher bounds
        int low=0;
        int high=rows*cols-1;
        //binary search
        while(low<=high){
            //to prevent integer overflow
            int midValue=low+(high-low)/2;
            int row=midValue/cols;
            int col=midValue%cols;
            //checking for the target with row and col values
            if(matrix[row][col]==target)
                return true;
            //if the target is less than the current row and col values
            else if(target<matrix[row][col])
                high=midValue-1;                
            //if the target is greater than the current row and col values
            else
                low=midValue+1;                
        }
        return false;
    }
}