// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if(matrix.length==0 || matrix==null) return false;
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int low=0;
        int high=m*n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/n; //get row value of element
            int col=mid%n; //get column value of element
            if(matrix[row][col]==target){
                return true;
            }else if(target<matrix[row][col]){
                high=mid-1; //move lower in the sorted matrix to find element 
            }else
                low=mid+1;  //move higher in the sorted matrix to find element
        }
        return false;
    }
}