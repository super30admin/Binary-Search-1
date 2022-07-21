// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * The overall approach is to consider the first element as 0th index (low) and last element as high Index in the 2D array.
 * We apply single binary search on the array with low = 0 and high = last element index.
 * 
 * We calculate the mid index and covert it to the equivalent row and column in 2D array.
 * Rest approach is plain Binary search.
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int low = 0;
        int high = rows * cols - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int[] xy = calculateXY(mid, rows, cols);
            
            int midNumber = matrix[xy[0]][xy[1]];
            
            if (midNumber == target) {
                return true;
            } else if (target > midNumber) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
    
    private int[] calculateXY(int index, int rows, int cols) {
        int row = (index) / cols;
        
        int col = index % cols;
        
        return new int[]{row, col};
        
    }
}