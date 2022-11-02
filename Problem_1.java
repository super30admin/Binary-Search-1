// Time Complexity : O(log(N))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Search a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        int low = 0;
        int high = (row*col) -1;
        int mid;
        
        while(low <= high){
            mid = (low + (high-low)/2);
            if(matrix[mid/col][mid%col] == target){
                return true;
            }
            else if(target < matrix[mid/col][mid%col]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}