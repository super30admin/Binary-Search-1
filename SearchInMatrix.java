// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

public class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //total row
        int n = matrix[0].length; // total col

        int low = 0;
        int high = m*n-1;

        while(low <= high) {
            int mid = (high-low)/2 + low;

            //Calculating the 2-D array indexes from 1-D array index
            int row = mid / n;
            int col = mid % n;

            if(target == matrix[row][col]) return true;
            else if(target < matrix[row][col]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
