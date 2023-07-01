// Time Complexity : Time complexity will be O(log(mn))
// Space Complexity : Space complexity is O(1) as no extra space is required
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// As the solution was required to be in O(log(mn)) time complexity, I used binary search in here. 
// I visualized the 2d matrix into 1d array and then performed binary search
// The time complexity would be dependent on the number of elements which is m*n

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == matrix[mid / n][mid % n]) {
                return true;
            } else if ((target > matrix[mid / n][mid % n])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;

    }
}