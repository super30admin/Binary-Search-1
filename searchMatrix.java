// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We assume the 2D Matrix to be a linear array and find the left, right and mid accordingly
    To find the row index of mid we do [mid/n] and column index [mid%n]
    We can access the element inside the matrix with matrix[rowindex][columnindex]
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length, l = 0, r = m * n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int val = matrix[mid/n][mid%n];
            if(val > target) r = mid - 1;
            else if(val < target) l = mid + 1;
            else return true;
        }
        return false;   
    }
} 