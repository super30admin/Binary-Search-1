// Time Complexity : O(log m*n) as it's binary search on the complete matrix size.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not much, once the idea to consider it as a single array and perform the binary search to achieve O(log m*n) it was
// better. The core part of the solution lies in identifying the position of mid element.

// Your code here along with comments explaining your approach


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length * matrix[0].length) - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int column = mid%matrix[0].length;
            int row = mid/matrix[0].length;
            if(matrix[row][column] == target){
                return true;
            }
            if(matrix[row][column] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return false;
    }
}