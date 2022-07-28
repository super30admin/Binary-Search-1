// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Considered the two dimensional array to a single dimensional array. And taking the low as 0 and high as
number of rows * no of columns. After finding the mid value, we can consider this to 2 day by diving the mid
with number of columns. So that we can find the row and column mid point in a 2D array.
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null||matrix.length==0) return false;

        int m  = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        int mid = 0;
        while(low<=high){
            mid = low + (high - low)/2;
            int r = mid/n;
            int c = mid%n;

            if(matrix[r][c]==target) return true;

            else if(matrix[r][c] > target){
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
        }

        return false;

    }
}