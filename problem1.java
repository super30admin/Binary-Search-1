// Time Complexity : O (log (mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach in three sentences only
// Considering the 2d array as 1d array and performing binary search on it
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            // selecting mid point
            int pivotIndex = low + (high - low) / 2;
            // column decides which row to look at. Hence using division to find the correct column
            int pivotValue = matrix[pivotIndex / n][pivotIndex % n];
            // match found
            if (pivotValue == target)
                return true;
                // pivot value is higher than target so moving high pointer to mid -1
            else if (pivotValue > target)
                high = pivotIndex - 1;
                // pivot value is lower than the target so moving the low pointer to mid +1
            else
                low = pivotIndex + 1;
        }

        // no match found
        return false;
    }
}