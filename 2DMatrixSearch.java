// Time Complexity :O(log n + log m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // getting the length of rows and columns
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Initialize left pointer to 0 and right pointer to last value of 2d array
        int left = 0;
        int right = rows * columns - 1;

        // Implementing binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int rowIndex = mid / columns; // this would help us get appropriate row index
            int columnIndex = mid % columns;// this would help us get appropriate column index

            if (matrix[rowIndex][columnIndex] == target) {
                return true;
            } else if (matrix[rowIndex][columnIndex] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //if the element is not present return false
        return false;
    }
}