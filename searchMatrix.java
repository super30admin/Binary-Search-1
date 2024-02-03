//Time Complexity - O(log(m*n))
//Space Complexity - O(1)
//Ran in Leetcode - Yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0)
            return false;
       int row = matrix.length;
       int col = matrix[0].length;
       int low = 0;
       int high = row*col-1;
       while(low<=high){
           int middle = low +(high-low)/2;
           int r = middle/col;
           int c = middle%col;
           if(matrix[r][c]==target)
               return true;
           else if(matrix[r][c]<target)
               low = middle+1;
           else
               high = middle-1;
       }
       return false;
    }
}
