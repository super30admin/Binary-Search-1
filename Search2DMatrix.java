// Time Complexity : O(log m * n)
// Space Complexity : O(1) //since we are noy using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Implement using binary search and imagine it to be a 1D array

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if(matrix == null || matrix.length == 0) return false;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int low = 0;
        int high = rowLength * columnLength - 1;
    

    //do binary search
         while(low<=high){
        int mid = low + (high-low)/2; //to prevent integer overflow
        //calculate the row and column index
         int row = mid / columnLength;
         int column = mid % columnLength;
             if(matrix[row][column] == target){
             return true;
         }
         else if(target < matrix[row][column]){
             high = mid -1 ;
         }
         else {
             low = mid + 1;
         }
         }
         return false;
    }
}