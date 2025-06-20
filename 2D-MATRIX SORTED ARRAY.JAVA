
// Time Complexity :O(log(m*n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1; //flattering the 2D array in to 1D array

       while (low <= high){
        int mid= low+(high-low)/2;
        int row= mid/n;  // to convert 1D index to 2D conversion for each iteartion
        int col=mid%n;
        int midvalue=matrix[row][col];

       if(target == midvalue){
        return true; // checking the target with mid value
       }else if (target < midvalue){ //target less than mid value will move to left
         high = mid-1;
       }else{
         low =mid+1; // else we will move to right
       }

       }
       return false;
    }
}