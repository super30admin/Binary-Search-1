// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null ||  matrix.length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            int midcol = mid%n;
            int midrow = mid/n;
            if(matrix[midrow][midcol]==target) return true;
            else if(matrix[midrow][midcol]>target){
               
                 high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}
