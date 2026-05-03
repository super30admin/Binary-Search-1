// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
I set low = 0 and high = total elements in matrix - 1 initially. While flattening the matrix into an array, we can see that the
row and column position of the middle element depends on the total number of columns present in the matrix. New row position = mid / total
columns and new column position = mid % total columns. I perform binary search on the flattened matrix and return true if the element
is present or false if low becomes greater than high (element is not present)
*/


public class Solution
{
    public bool SearchMatrix(int[][] matrix, int target)
    {
        int rows = matrix.Length, columns = matrix[0].Length;
        int low = 0, high = rows * columns - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            int nr = mid / columns;
            int nc = mid % columns;

            if (matrix[nr][nc] == target)
            {
                return true;
            }

            else if (matrix[nr][nc] < target)
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