// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NONE

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // total number of rows
        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows*columns -1;
        int mid=0;int row=0;int col=0;

//         which row the value is present is deterinded by number of columns, and where it is present is determined by the remainder and number of columns

        while(low<=high)
        {
            mid = low+(high-low)/2;
            row = mid/columns;
            col = mid%columns;

            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }

        }
        return false;
    }
}