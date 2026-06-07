// Time Complexity : O(log m*n) where m is the number of rows and n is the number of columns in the matrix
// Space Complexity : O(1) as we are using constant space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only 
//treat 2d matrix as 1d array and apply binary search to get row and column index from mid value and compare with target tp get the result.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m*n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int r = mid / n;
            int c = mid % n;

            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }

        return false;

    }
}