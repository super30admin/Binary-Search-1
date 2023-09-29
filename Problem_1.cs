public class Solution
    {
        // Time Complexity : O(log m * n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public bool SearchMatrix(int[][] matrix, int target)
        {
            if (matrix.Length == 0)
                return false;

            int m = matrix.Length;
            int n = matrix[0].Length;
            int low = 0;
            int high = m * n - 1;

            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                int rowIndex = mid / n;
                int colIndex = mid % n;
                if (matrix[rowIndex][colIndex] == target)
                {
                    return true;
                }
                else if (matrix[rowIndex][colIndex] < target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            return false;
        }
    }
