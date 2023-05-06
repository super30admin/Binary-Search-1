/*
 * Time Complexity: 0(log(mn))
 * Space Complexity: 0(1)
 */

namespace LeetCodeSubmission.BinarySearch1;

public class SearchA2DMatrix
{
    public bool SearchMatrix(int[][] matrix, int target)
    {
        // dimensions of matrix
        int rows = matrix.GetLength(0);
        int cols = matrix[0].GetLength(0);
        
        int low = 0;
        int high = rows * cols - 1;

        while (low <= high)
        {
            int mid = (high - low) / 2 + low;
            
            // get mid dimensions
            int midRow = mid / cols;
            int midCol = mid % cols;

            if (matrix[midRow][midCol] == target)
            {
                return true;
            }

            if (matrix[midRow][midCol] > target)
            {
                // target on lhs
                high = mid - 1;
            }
            else if (matrix[midRow][midCol] < target)
            {
                // target on rhs
                low = mid + 1;
            }
        }
        
        return false;
    }
}