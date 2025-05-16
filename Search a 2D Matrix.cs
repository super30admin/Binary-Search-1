/*
  Time complexity: O(log mn) = O(log m + log n)
  Space complexity: O(1)

  Code ran successfully on Leetcode: Yes

  Approach: The row and column on which the target value might exist is computed by mid/n for row and mid%n for column. The binary search is then performed on the values.

*/

public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int m = matrix.Length;
        int n = matrix[0].Length;

        int low = 0;
        int high = m*n-1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int r = mid/n;
            int c = mid%n;

            if(matrix[r][c]==target)
            {
                return true;
            }
            else
            {
                if(target<matrix[r][c])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
        }
        return false;
    }
}
