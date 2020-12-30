// Time Complexity : O(log(mn))
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0; 
        int h = (m*n)-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target){
                 return true;
            }
            else if(matrix[row][col] > target){
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}