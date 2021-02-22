// Time Complexity : O(log(n*m)) where n is the number of rows and m is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        // left and right pointers of the matrix as a flattened array
        int left =0,right=row*col-1;
        while(left <= right){
            int mid = left+(right -left)/2;
            
            // Finding the middle row and col of the matrix
            int i = mid/col;
            int j = mid%col;
            
            // Binary Search to find the target element from the middle of the matrix
            if(matrix[i][j] < target) left = mid+1;
            else if(matrix[i][j] > target) right = mid-1;
            else return true;
        }
        return false;
    }
}
