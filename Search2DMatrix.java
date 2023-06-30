
// Time Complexity : O(log(m * n))
// Space Complexity : O(1) because we only use a constant amount of extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1; // Finding index of last element of flattened matrix

        while (left <= right) {
            int mid = left + (right - left) / 2; // Finding mid index of flattened matrix
            int midValue = matrix[mid / cols][mid % cols]; // Finding mid value of flattened matrix

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}