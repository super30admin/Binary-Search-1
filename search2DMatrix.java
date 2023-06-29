// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

//Implemented a binary search assuming all the matrix elements are in a 1d array by modifying the mid element accordingly.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1;
        System.out.println("Rows: "+rows+", Cols: "+cols);

        while(low <= high){
            int mid = low + (high-low)/2;
            int midRow = mid / cols;
            int midCol = mid % cols;
            int currValue = matrix[midRow][midCol];
            if(currValue == target){
                return true;
            }else if(currValue > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return false;
    }
}