// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :    no


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n - 1;

        while(start <= end){
           int mid = start + (end-start)/2;
            int mid_element=matrix[mid/n][mid%n];

            if(mid_element== target){
                return true;
            }

            else if(mid_element <= target){
                start = mid + 1;
            }

            else{

                end = mid - 1;
            }
        }
        return false;
    }
}