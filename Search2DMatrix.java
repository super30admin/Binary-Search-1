/* Time Complexity : O(log n*m)
Space Complexity : O(m); array created to run binary search on 1st col
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach in three sentences only:
Binary search on first column, then binary search on the row with potential result
*/

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search first col
        int[] firstColumnArr = new int[matrix.length];

        // copy first row to matrix
        for (int i = 0; i < matrix.length; i++) {
            firstColumnArr[i] = matrix[i][0];
        }

        // this gives us row to search
        int rowToSearch = binarySearch(firstColumnArr, 0, firstColumnArr.length - 1, target);

        // check if target is smaller than the smallest num or bigger than the biggest
        if (rowToSearch < 0 || rowToSearch >= matrix.length)
            return false;

        // if it exists in the first col
        if (matrix[rowToSearch][0] == target)
            return true;

        int result = binarySearch(matrix[rowToSearch], 0, matrix[rowToSearch].length - 1, target);

        if (matrix[rowToSearch][result] == target) {
            return true;
        }

        return false;
    }

    // standard binarySearch algo
    public int binarySearch(int[] nums, int low, int high, int target) {
        int mid;
        while (low <= high) {
            mid = Math.round((low + high) / 2);
            if (target == nums[mid])
                return mid;

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}