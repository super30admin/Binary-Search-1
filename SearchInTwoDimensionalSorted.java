class SearchInTwoDimensionalSorted {

    // Time Complexity : O(logmn)
    // Space Complexity :o(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : No

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mi = low + (high - low) / 2;
            // Dividing mid value with the column size gives the row number
            // Modular division with the column size gives the col number
            int r = mi / n;
            int c = mi % n;

            int mid = matrix[r][c];
            if (mid == target) {
                return true;
            } else if (mid < target)
                low = mi + 1;
            else
                high = mi - 1;
        }
        return false;

    }
}