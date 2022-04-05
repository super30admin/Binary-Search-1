/**
Problem: Search in a 2-D sorted matrix.
https://leetcode.com/problems/search-a-2d-matrix/

Time Complexity : log (m * n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
*/

class SearchInSorted2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        
        if (rows == 0) {
            return false;
        }
        
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }
        
        // Treat the 2d matrix as a 1d sorted array and perform binary search on it.
        int low = 0, high = rows * cols - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Get convert index of mid in 1d array to 2d array
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (target > matrix[mid / cols][mid % cols]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}