// Time Complexity : 0ms (faster than 100% submissions)
// Space Complexity : 42.5 MB (less than 49.73 submissions)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int s = 0;
        int e = r * c - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (matrix[mid / c][mid % c] == target) {
                return true;
            } else if (matrix[mid / c][mid % c] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;

    }
}