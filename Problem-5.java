// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Consider matrix as 1-D array of lenght m * n 
// then we have all elements sorted in 1-D array and using Binary search here
// We need to find mid element based on this idea
class Problem5 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        int midIndex;
        int midElement;

        while (left <= right) {
            midIndex = (left + right) / 2;
            int row = midIndex / n;
            int col = midIndex % n;

            midElement = matrix[row][col];

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                // search in right side
                left = midIndex + 1;
            } else {
                // search in left side
                right = midIndex - 1;
            }
        }

        return false;
    }
}
