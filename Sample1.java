// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* Initially, I set low as 0, high as number of rows * number of columns -1. I execute a while loop until low becomes greater than high,
 * I calculate mid as (low+high)/2. Now the exact row of the mid element is obtained by dividing mid with the number of columns and the exact
 * column is obtained by taking the modulus of mid with number of rows. If matrix[r][c]<target then low = mid+1 else if matrix[r][c]>target 
 * then high = mid-1 else return true.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0,high = rows*columns-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int r = mid/columns;
            int c = mid%columns;
            if(matrix[r][c]==target)
            {
                return true;
            }
            else if(matrix[r][c]<target)
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