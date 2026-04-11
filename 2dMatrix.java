// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixLen = matrix[0].length ;
        int high = (matrix.length * matrixLen)-1;
        int low = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int m = mid/matrixLen;
            int n = mid%matrixLen;
            if(matrix[m][n]==target){
                return true;
            }
            if(matrix[m][n]<target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
}