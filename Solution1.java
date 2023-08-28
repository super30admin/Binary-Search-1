// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
A n * m matrix converted into an array: matrix[x][y] → a[x * m + y]
An array can be converted into n * m matrix: a[x] → matrix[x / m][x % m]
On the basis of this, binary search is applied to traverse throught the matrix and find the target element
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0;
        int high = rows*columns-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (matrix[mid/columns][mid%columns]==target)
            {
                return true;
            }
            else if(matrix[mid/columns][mid%columns]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return false;
    }
}