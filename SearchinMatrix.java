// Time Complexity :O(Log(M*N))
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes
//Still confused about the index conversion, need to think deeper on the question.


// Your code here along with comments explaining your approach in three sentences only
// I made use of the solution discussed in class.
// We can treat the 2D matrix as a 1D array and apply binary search on it. 
// We can calculate the mid index and convert it back to row
//  and column index using the number of columns in the matrix. 
// We can then compare the mid value with the target and adjust 
// the low and high pointers accordingly until we find the target or the search space is empty.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
