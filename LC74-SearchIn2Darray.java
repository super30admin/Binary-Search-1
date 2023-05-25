// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only

/**
Consider 2d array as 1d array with index  x = i*col + j for i as row index(0 to r-1), j is column index(0,c-1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // left and rigth ptr
        int row = matrix.length;
        int col = matrix[0].length;

        int l=0;
        int r= row*col - 1;

        while(l<=r) {
            int mid = (l+r)/2;
            int i = mid/col; // will give row index for mid
            int j = mid - i*col; //will give col index for mid

            if (matrix[i][j] == target) return true;

            if (matrix[i][j] > target) r=mid-1;
            else l = mid+1; 
        }

        return false;
    }
}