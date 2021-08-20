// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0)
            return false;
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int pivotIdx = (left + right) / 2;
            int pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if(pivotElement == target) {
                return true;
            } else if(pivotElement < target) {
                left = pivotIdx + 1;
            } else {
                right = pivotIdx - 1;
            }
        }
        return false;
    }
}