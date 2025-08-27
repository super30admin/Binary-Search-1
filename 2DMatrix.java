// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Unable to figure the best method to tackel  this problem
// Approach: Assume the 2D matrix as a 1D array
//           Perform binary search on the array
//           Compare target with mid and change the low and high accordingly.


class 2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target){
                return true;
            }
            else if (target < matrix[row][col]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}