// Time Complexity  : o(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (https://leetcode.com/problems/search-a-2d-matrix/)
// Any problem you faced while coding this : no
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        int low = 0;
        int high = m * n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int rowIndex = mid / n;
            int colIndex = mid % m;
            if(matrix[rowIndex][colIndex] == target) {
                return true;
            } else if (matrix[rowIndex][colIndex] < target) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }
}