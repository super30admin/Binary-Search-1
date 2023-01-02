// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length;    //no of columns
        int n = matrix[0].length; //no of rows

        int low = 0;
        int high = m*n - 1; // since we are flattening it out

        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid%n;
            
            if (matrix[r][c] == target) return true;

            else if (matrix[r][c] > target){
                high = mid -1;        
            }

            else {
                low = mid +1;
            }

        }
        return false;
    }
}