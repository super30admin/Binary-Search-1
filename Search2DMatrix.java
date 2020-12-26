// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length; //rows
        int n = matrix[0].length; //cols
        int low = 0;
        int high = m*n - 1;

        while(low <= high)
        {
            int mid = low + ( high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target)
                return true;
            else if (matrix[row][col] >= target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;

    }
}
