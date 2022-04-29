// Time Complexity :logm+logn where m is row n is column
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int start = 0;
        int end = row;

        while (start <= end) {// we'll check each row if target falls inside the row range
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] <= target && matrix[mid][column] >= target) {// if row is found, we do binary search on
                                                                            // row
                return binarySearch(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {// simple binary search
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
// --------------------------converting into 2D matrix----------------
// Time Complexity :log(m+n) where m is row n is column
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;// converting array into 1D then applying binary search to it
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;// calculating row
            int column = mid % n;// calculating column
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}