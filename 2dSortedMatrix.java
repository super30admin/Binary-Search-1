// Time Complexity :O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//here the interviewer is looking for the range of the solution you provide not just the solution
//1. m*n 2. nlogm 3.log(m*n) 4. 5.
//the key is covert this 2D matrix into a 1D array 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int mid;
        int low = 0, high = row*col-1;

        while(low<=high){
            mid = low +(high-low)/2;

            int r = mid/col;
            int c = mid%col;

            if(matrix[r][c]==target){
                return true;
            }

            if(matrix[r][c]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return false;
    }
}