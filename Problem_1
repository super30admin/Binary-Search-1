// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We treat the 2d array as a 1d array and perform binary search on the same. After calculating mid of 1d array, we use
   mid / columns & mid % columns to get the corresponding indices in 2d array. If target is less than mid we use end = mid - 1
   else we use start = mid + 1;
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false; 
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        int end = (rows * columns) - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            int r = mid / columns;
            int c = mid % columns;

            if(matrix[r][c] == target)
                return true;

            if(target < matrix[r][c])
                end = mid - 1;
            else
                start = mid + 1;
        }

    return false;
    }
}