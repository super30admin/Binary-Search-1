// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding row and col from mid
// https://leetcode.com/problems/search-a-2d-matrix/


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //considering 2D array as linear array
        if(matrix == null || matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalLen = rows*cols; // computing total array
        int left = 0;
        int right = totalLen-1;
        
        while(left<=right) {  // Binary Search Algorithm
            int mid = left + (right-left)/2;
            int r = mid/cols;   // getting row from linear array index
            int c = mid%cols;   // getting column from linear array index
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    
}