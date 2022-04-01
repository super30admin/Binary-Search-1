// Time complexity: O(log m*n) where m*n is the number of elements.
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {      // Testing for base case.
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high) {                        // Binary Search
            int mid = low + (high - low) / 2;       // To prevent integer overflow.
            int row = mid / n;
            int column = mid % n;
            if(matrix[row][column] == target) {
                return true;
            }
            else if(matrix[row][column] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}