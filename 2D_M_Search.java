// Time Complexity : O(log(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int midVal = matrix[mid / cols][mid % cols];

            if(midVal > target){
                high = mid - 1;
            }else if(midVal < target){
                low = mid + 1;
            }else if(midVal == target) return true;
        }

        return false;
    }
}
