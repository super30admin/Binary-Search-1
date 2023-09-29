// Time Complexity : log(m) + log(n) where m steps to find target row & n steps to find target column.
// number of element to search for the target.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchIn2DMatrix
{
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target)
        {
            int targetRow = binarySearchRow(matrix, target);
            if (targetRow == -1)
                return false;
            else
                return binarySearchCol(matrix, target, targetRow);
        }

        public int binarySearchRow(int[][] matrix, int target)
        {
            int low = 0, high = matrix.length-1;
            int maxCol = matrix[0].length-1;

            while(low <= high)
            {
                int mid = low + (high - low)/2;
                if (target >= matrix[mid][0] && target <= matrix[mid][maxCol])
                    return mid;
                else if (target < matrix[mid][0])
                    high = mid-1;
                else
                    low = mid+1;
            }
            return -1;
        }

        public boolean binarySearchCol(int[][] matrix, int target, int targetRow)
        {
            int low = 0, high = matrix[0].length-1;

            while(low <= high)
            {
                int mid = low + (high - low)/2;
                if (target == matrix[targetRow][mid] )// && target <= matrix[targetRow][mid])
                    return true;
                else if (target < matrix[targetRow][mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            return false;
        }
    }
    class Solution2
    {
        public boolean searchMatrix(int[][] matrix, int target)
        {
            int rows = matrix.length, cols = matrix[0].length;
            int low = 0, high = (rows * cols) - 1;

            while (low <= high)
            {
                int midIndex = low + (high-low)/2;
                int curRow = midIndex/cols;
                int curCol = midIndex%cols;
                if(target == matrix[curRow][curCol])
                    return true;
                else if (target < matrix[curRow][curCol])
                    high = midIndex -1;
                else
                    low = midIndex + 1;
            }
            return false;
        }
    }
}
