// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* To search an element in a sorted 2D array, we can find out the low, high and mid index.
From the mid index, I can find out row and column of the mid element.
row = mid /n;
col = mid % n;
Then apply binary search. */

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix == null || matrix.length == 0) return false;
        int low = 0;
        int high = (m*n)-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int rowIndex = mid / n;
            int colIndex = mid % n;
            if(matrix[rowIndex][colIndex] == target) return true;
            else if(matrix[rowIndex][colIndex] > target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}
