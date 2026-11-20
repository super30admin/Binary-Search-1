// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// I am considering 2D as 1D array calculated its length with rows * columns-1;i run a while loop until low <=high, calculating mid evrytime.
// Since it is 2D array to search mid i calculated it row with mid / column length and col with mid % column length.
// I will check target == matrix[row][col] if yes i retur true , else if target < matrix[row][col] if yes i will move high to mid -1, else low=mid +1
// if while loop breaks i comes out and return false; 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int low=0;
        int high=rows*cols-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid / cols;
            int col=mid % cols;
            if(matrix[row][col]==target){
                return true;
            }
            if(target<matrix[row][col]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
             

        }
        return false;

    }
} 
