// 74. Search a 2D Matrix
// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// we can imagine the sorted array in the form of (row = mid/n) & (column = mid%n)
// now apply the usual binary search on the matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;

        while(low <= high) {
            //int mid = low + (high-low)/2; this one is better since high+low might cause overflow issue if both high & low are very large.
            int mid = (high+low)/2;
            int r = mid/n;
            int c = mid%n;

            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
}