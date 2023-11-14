// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Here, for applying binary search, we need the row and column of mid index of the 2d array, the binary search.
 * To do that, Initially, we assume the 2d array as a 1d array with all rows one after the other. Calculate low & high. Now apply
 * binary search with this low, high, Find row=mid/ColLen, col=mid%colLen. Now check if matrix[row][col] is ==, > or < target.
 */

public class SearchIn2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int low = 0;
        int high = (rowLen * colLen) - 1;

        while(low <= high) {

            int mid = low + (high-low)/2;
            int row = mid / colLen;
            int col = mid % colLen;

            if(matrix[row][col] == target)
                return true;
            else if (target < matrix[row][col])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;
    }
}
