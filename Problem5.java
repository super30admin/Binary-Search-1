// Time Complexity : O(m*n), where m is no of rows and n is no. of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;

        int col = matrix[0].length;
        int start = 0;
        // end would be 11 for 3*4 as start = 0
        int end = matrix.length * matrix[0].length - 1;


        while(start <= end){
            int mid = start + (end - start) / 2;
            int element = matrix[mid / col][mid % col];

            if(target > element){
                start = mid + 1;
            }else if(target < element){
                end = mid - 1;
            }else{
                return true;
            }
        }

        return false;
    }
}