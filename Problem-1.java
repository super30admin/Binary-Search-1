// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Consider the 2d matrix as a 1d array and perform binary search
// Calculate the index for row = mid / columns and col = mid % columns

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = 0;
        int high = r * c - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            // Calculate the row and column index
            int i = mid / c;
            int j = mid % c;
            
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}