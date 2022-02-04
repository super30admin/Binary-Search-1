// Time Complexity : O(log (m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = (m * n) - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            int i = mid / n;
            int j = mid % n;
            
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}