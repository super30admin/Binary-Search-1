//## Problem1 Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach in three sentences only
// approach: It was assumed that the 2D matrix is flattened and is a single array. This array is sorted by the nature of the problem given, binary search was applied on this array which is of size m*n. The position in the 2D matrix of the elements was calculated using division and modulus function.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row;
        int column;

        if (matrix == null || matrix[0]==null)
        {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low =0;
        int high = (m*n) -1;
        int mid;

        while(low<=high)
        {
            mid = low + (high-low)/2;
            row = mid/n;
            column = mid%n;
            if(matrix[row][column]==target)
            {
                return true;
            }
            else if(matrix[row][column]<target)
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }
        return false;
    }
}