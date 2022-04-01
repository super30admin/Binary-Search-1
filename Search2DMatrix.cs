using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    class Search2DMatrix
    {
        public bool SearchMatrix(int[][] matrix, int target)
        {
            if (matrix == null || matrix.Length == 0)
                return false;

            int m = matrix.Length;
            int n = matrix[0].Length;

            int start = 0;
            int end = m * n - 1;

            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                int row = mid / n;
                int column = mid % n;
                if (matrix[row][column] == target)
                    return true;

                if (matrix[row][column] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            return false;
        }
    }
}
