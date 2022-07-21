// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=0;
        int n = matrix[m].length - 1;
        while(m<matrix.length && n>=0){
            if(matrix[m][n]==target){
                return true;
            }
            if(matrix[m][n] < target)
                m++;
            else
                n--;
        }
        return false;
    }
}