// Time Complexity : O(log (m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
We use binary search as an optimal approach where we try to assume entire matrix as a single array and
eliminate low/high subarray search by checking the respective row and column index value comparisons.
During this process of viewing the matrix as single array, we iterate r and c values by divide and modulo
operations with the column and mid values.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0 , high = m*n-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int r = mid / n;
            int c = mid % n;

            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}