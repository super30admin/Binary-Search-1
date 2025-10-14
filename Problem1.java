// 74. Search in a 2D Matrix
// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (Could not try since LC premium Question but ran on multiple example values)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// 1. Row 1 is sorted and the next row begans after first ends and is sorted again
// 2. Row 1,2,3 can be flattened into one big single row of length, m*n
// 3. Index of row can be calculated by i/n and columns as i%n where n would be the column. 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
