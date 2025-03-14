// Time Complexity : O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Here we need to imagine 2D array as 1D array
        // Thus we need to calculate number of rows and number of columns 
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        // When we imagine array as 1D then we set low as 0
        // high as total number of elements - 1
        int low = 0;
        int high = numberOfRows * numberOfColumns - 1;

        // This would be normal binary search
        // Now here mid would determine would be determined using 1D array formula
        // But then we need to find the mid in actual 2D array
        // To do that we use formula mid / number of columns to determine the row 
        // mid % number to determine column 
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / numberOfColumns;
            int colums = mid % numberOfColumns;
            if(matrix[row][colums] == target) return true;

            if(matrix[row][colums] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}