// Time Complexity : O(logm + logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            
            // check if calculated mid is equal to target
            if(matrix[row][col] == target)
                return true;
            // if target is less then move to left part of array
            else if(target < matrix[row][col]) {
                high = mid - 1;
            }
            // if target is greater then move to right part of array
            else if(target > matrix[row][col]) {
                low = mid + 1;
            }
        }
        return false;
    }
}