//Time Complexity : log(m*n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

//Approach
/*  //Considereing,  convert the 2-d array into 1-d array,
 *  starting index = 0 , end index = m*n-1
 *  row_index = mid / col;
 *  col_index = mid % col;
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target ) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}