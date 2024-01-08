// Time Complexity :log n
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
}