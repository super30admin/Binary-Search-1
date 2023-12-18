// Time Complexity : O(log(rows * cols))
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1, mid, row_index, col_index;

        while(low <= high)
        {
            mid = low + (high - low) / 2;

            row_index = mid / cols;
            col_index = mid % cols;

            if(matrix[row_index][col_index] == target) return true;

            else if(matrix[row_index][col_index] < target) low = mid + 1;

            else high = mid - 1;
        }

        return false;
    }
}