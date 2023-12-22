// Time Complexity : O(log(m * n)) where m*n is matrix
// Space Complexity : O(1) not sure
// Approach : applying binary search over each row of matrix 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / col;
            int c = mid % col;

            if(matrix[r][c] == target) return true;

            if(matrix[r][c] < target) { 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}