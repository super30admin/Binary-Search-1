// Time Complexity : O(log(m × n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// This 2D matrix is treated as a single 1D array because each row is sorted and
// last element of previous row is lesser than the first element of next row
// Binary search is applied on the virtual 1D array.
public class Solution
{
    public bool SearchMatrix(int[][] matrix, int target)
    {
        int m = matrix.Length;
        int n = matrix[0].Length;

        int low = 0, high = m * n - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] == target)
            {
                return true;
            }
            else if (matrix[r][c] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return false;
    }
}