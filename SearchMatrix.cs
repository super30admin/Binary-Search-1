using System;
namespace Algorithm
    /// Time Complexity : O(log(mn))
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No

    public class SearchMatrix
    {
        public bool SearchInMatrix(int[][] matrix, int target)
        {
            int m = matrix.Length;
            if (m == 0) return false;
            int n = matrix[0].Length;
            int left = 0, right = m * n - 1;
            int pivotIndex, pivotIndexElement;

            while(left <= right)
            {
                pivotIndex = (left + right) / 2;
                pivotIndexElement = matrix[pivotIndex / n][pivotIndex % n];
                if (target == pivotIndexElement) return true;
                if(target < pivotIndexElement)
                {
                    right = pivotIndex - 1;
                }
                else
                {
                    left = pivotIndex + 1;
                }
            }
            return false;
        }
    }
}
