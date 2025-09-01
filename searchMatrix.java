// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Came up with this solution before the class, does not follow instructors O(logmn) solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target) == true) {
                return true;
            }
        }

        return false;
    }

    public boolean binarySearch(int[] n, int target) {
        int left = 0;
        int right = n.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (n[mid] == target) {
                return true;
            } else if (n[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return false;
    }
}