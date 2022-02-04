//Time Complexity = O(LOGmn)
//Space Complecity = O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int beg = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int end = m * n - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] > target) {
                end = mid - 1;
            } else if (matrix[i][j] < target) {
                beg = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }
}