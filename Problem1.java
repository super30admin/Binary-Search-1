//https://leetcode.com/problems/search-a-2d-matrix/

// Time Complexity : O(log(mn)) where mXn are the number of elements in input matrix
// Space Complexity : Constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nod


// Your code here along with comments explaining your approach in three sentences only
// Explanation in comments in code

class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // To do this O(log(mn)), we are going to imagine this 
        // 2D matrix as a 1D array with mxn elements.
        // where m, n are the rows and cols respectively of the matrix

        // Employ binary search on this range 1 to mxn
        int l=0, r=(matrix.length*matrix[0].length)-1;
        while(l<=r){
            int mid=l+(r-l)/2;
             // Mapping from 1D index to 2D: 
             // row(x)=x/n and col(x)=x%n, 
             // where x is the given 1D index
            int row=mid/matrix[0].length;
            int col=mid%matrix[0].length;

            if(matrix[row][col]==target)    return true;
            if(target<matrix[row][col]) r=mid-1;
            else    l=mid+1;
        }
        return false;
    }
}
