using System;
//Time complexity : O(log(m*n))
//Space complexity: O(1)
public class Search2DArray{
     public bool SearchMatrix(int[][] matrix, int target)
        {
            if (matrix == null || matrix.Length == 0)
            {
                return false;
            }
            int m = matrix.Length, n = matrix[0].Length;
            int low = 0;
            int high = m * n - 1;
            while (low <= high)
            {
                int mid = low + (high - low) / 2; //prevent integer overflow
                int r = mid / n;
                int c = mid % n;
                if (matrix[r][c] == target)
                {
                    return true;
                }
                else if (target > matrix[r][c])
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