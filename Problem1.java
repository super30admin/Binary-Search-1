
// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// No major issues—just had to convert 1D index to 2D and avoid out-of-bound errors.


// I treat the 2D matrix like a sorted 1D array by mapping mid index to matrix[mid/n][mid%n]. 
// Then I apply standard binary search to compare mid element with the target and adjust search boundaries. 
// This works in O(log(m*n)) because the entire matrix behaves as one sorted list.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        // Treat matrix as a 1D sorted array and apply binary search.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / n][mid % n];

            if (val == target) return true;
            else if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;  
    }
}
