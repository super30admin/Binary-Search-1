// Time Complexity : log(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes mid calcaution is a bit weird to wrap my head around as i ma seeing it for the first time

/*
 * we are treating 2D matrix as a 1d matrix as in the problem statment is it given that last number of row will be smaller then the
 * first number of the next row
 * 
 * we are calculating mid as if it was a 1d array and after after words we are converting that mid to row and column index using row size
 * divide by row size for row postion and modlus by row size to get column postion
 * 
 * we will use standard binary search 
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length * matrix.length - 1;
        int n = matrix[0].length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / n;
            int c = mid % n;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;

    }
}