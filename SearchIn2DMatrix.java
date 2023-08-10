// Time Complexity : (log m + log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Assume the values in the matrix as a single dimension array(values are read row wise from left to right), compute the mid value, find the 
// row and the column number for this mid in the matrix, compare the value in matrix with the target and if there is no match continue the 
// binary search which reduces the search space for reach iteration until the match is found or matrix is exhausted.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;

        while(low<=high){
            int mid = low+(high - low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c]==target){
                return true;
            } else if(matrix[r][c]>target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}