// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

// Time Complexity : log(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : By consider the complete matrix as an array and applying binary search on the completed array

public class problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        int mid;
        int c = 0;
        int r = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            c = mid % m;
            r = mid / m;
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
