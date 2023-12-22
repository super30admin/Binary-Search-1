/*
* Approach: 
*  1. Considering 2D matrix as 1D array.
* 
*  2. Initialize low = 0 and high = m*n -1
        apply Binary Search over this range.
* 
*  3. Get the row and col numbers and compare with target
        row = mid / n
        col = mid % n
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(log(m*n))
        Linear Search : O(m*n)

        Linear Search from top-right corner: O(m+n)

        Linear + Binary Search : O(m+logn) or O(logm+n)

        Double Binary Search:  O(log(m) + log(n)) ==== similar to O(log(m*n))
            Binary Search over rows + Binary Search over cols       
* 
* Space Complexity: O(1)
* 
*/

public class SearchSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length,
                columns = matrix[0].length;

        int low = 0, high = rows * columns - 1, mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            int row = mid / columns;
            int col = mid % columns;

            if (matrix[row][col] == target)
                return true;

            else if (matrix[row][col] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return false;
    }
}