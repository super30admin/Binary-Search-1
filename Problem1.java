// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// Perform bunary serch on converting 2D arrary to 1D array so that we get the row by dividing by n and 
//column by %n. 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length-1;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
           int r_low = 0;
           int r_high = m*n-1;
           while(r_low <= r_high){
            int mid=(r_low+r_high)/2;
            int midX=mid/n;
            int midY=mid%n;
                  if(matrix[midX][midY] == target){
                        return true;
                    }else if(matrix[midX][midY] < target){
                        r_low  = mid + 1;
                    }else{
                        r_high = mid-1;
                    }
           }
        return false;
    }
}