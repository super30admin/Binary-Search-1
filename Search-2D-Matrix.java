// Time Complexity : O(n*logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/search-a-2d-matrix/

// Your code here along with comments explaining your approach in three sentences only
//I performed Binary Search considering the matrix as a sequence of elements

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        // base case
        if (mat.length == 0 || mat == null)
            return false;
        // otherwise
        int rows = mat.length;
        int cols = mat[0].length;
        int n = rows * cols;
        // binary search
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (mat[row][col] == target)
                return true;
            if (target < mat[row][col])
                r = mid;
            else
                l = mid + 1;
        }
        return false;
    }
}
