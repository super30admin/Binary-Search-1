namespace Algorithms
{
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No. Even though the caluclation of Indices for the mid calculation was not intentional,
    // it got clarified after going through the class video again.
    public class SearchMatrix
    {
        //Time Complexity - O(log mn) since we are reducing the search space by half in 2D array while going through this imaginary flattened sorted array
        //Space Complexity- O(1) since we are iterating within the given 2D array and we are not using any additional space
        public bool Search(int[][] matrix, int target)
        {
            if (matrix == null || matrix.Length == 0)
            {
                return false;
            }

            var rows = matrix.Length;
            var cols = matrix[0].Length;
            var left = 0;
            var right = rows * cols - 1;

            while (left <= right)
            {
                var mid = left + (right - left) / 2;
                var row = mid / cols; // Caluclating row index for the mid element
                var col = mid % cols; // Calculating column index of the mid element
                if (matrix[row][col] == target) return true;
                else if (matrix[row][col] < target)
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
