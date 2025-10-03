// Time Complexity : O(log(m*n)). m is the number of rows and n is the number of columns 
// Space Complexity : O(1) as we do not use any extra space

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Search in a 2D array
 */

/*
* Approach: Single Binary Search on 2D array(by treating it as a 1D array)
* In this approach, we perform binary search on the 2D array imagining it as a 1D array. We start by
* setting the left and right pointers to the start and end of the array. We simply retrieve
* the exact row and column by performing div and modulus operations on the mid index by number of columns. 
* If we find the target at this location we return true or else we discard the portions of 2D array we are not interested in. 
* We keep repeating the binary search on the included portion until we find the target. 
* At the end, if we don't find one, we return false.
*/
public class SearchInA2DMatrix_SingleBinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        // We return false if matrix is null or empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int mid, midValue;

        while (left <= right) {
            mid = left + (right - left) / 2;
            
            int r = mid / n;
            int c = mid % n;
            midValue = matrix[r][c];

            if (target == midValue) return true;
            else if (target < midValue) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;
        int target2 = 100;

        SearchInA2DMatrix_SingleBinarySearch searchInA2DMatrix = new SearchInA2DMatrix_SingleBinarySearch();
        System.out.println(searchInA2DMatrix.searchMatrix(matrix, target1));
        System.out.println(searchInA2DMatrix.searchMatrix(matrix, target2));
    }
}