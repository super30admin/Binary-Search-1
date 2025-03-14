// Time Complexity: O(log(m*n))
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach: Treat the 2D matrix as a flattened sorted array and apply binary search.
// Calculate the mid index and map it to matrix indices using row = mid / cols and col = mid % cols.
// Adjust search boundaries based on comparison with the target


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = (matrix[0].length * matrix.length) -1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            int i = mid/matrix[0].length;
            int j = mid%matrix[0].length;
            if(matrix[i][j] == target)
            {
                return true;
            }
            else if(matrix[i][j] > target)
            {
                r =mid-1;
            }
            else
            {
                l= mid+1;
            }
        }
        return false;
    }
}