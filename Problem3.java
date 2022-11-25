// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //setting low to first value and high to last value in the matrix
        int low = 0;
        int high = m * n - 1;
        //apply binary search
        while(low <= high) {
            int mid = low + (high - low) / 2;
            //picking the value of mid in the matrix from imaginary array
            int midRowValue = mid / n;
            int midColValue = mid % n;

            if(matrix[midRowValue][midColValue] == target) {
                return true;
            } else {
                if(matrix[midRowValue][midColValue] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;

    }
}