// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            //check if the target lies in the current row
            if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target){
                int lower = 0;
                int upper = matrix[i].length;
                int mid = 0;
                //implement binary search
                while(lower<=upper){
                    mid = lower+((upper-lower)/2);
                    if(target<matrix[i][mid])
                        upper = mid-1;
                    else if(target>matrix[i][mid])
                        lower = mid+1;
                    else if(target == matrix[i][mid])
                        return true;
                }
            }
        }
        return false;
    }
}
