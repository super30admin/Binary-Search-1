// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m*n)-1;

        while(low <= high) {
            int mid = low+(high-low)/2; //to prevent integer overflow
            int row = mid/n; // to find the row index in the matrix
            int col = mid%n; // to find the row index in the matrix

            //Do binary search of the target in the matrix
            if(target > matrix[row][col]){
                low = mid+1;
            } else if(target < matrix[row][col]){
                high = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}