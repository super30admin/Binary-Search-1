// Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes
// -Faced Diffficulty in found why we used / and %.But Indentified the reaso
// later

// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;
        // Flatten the 2D into 1D Array
        int high = m * n - 1;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            // Find the Middle Element of Flat array by / for row and % for column
            int midElement = matrix[mid / m][mid % m];
            if (midElement == target)
                return true;
            else if (midElement < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}