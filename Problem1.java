// Time Complexity : O(log(m*n)) where m is the number of rows and n is the number of columns in the matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// We are treating the 2D matrix as a 1D array and applying binary search on it. 
// We calculate the mid index and then find the corresponding row and column in the matrix using the mid index. We then compare the value at that position with the target and adjust our low and high pointers accordingly until we find the target or exhaust our search space.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m*n;
        int low = 0; 
        int high = total-1;
        while(low<=high){
            int mid = low + (high-low/2);
            int row = mid/n;
            int column = mid%n;
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
        
    }
}