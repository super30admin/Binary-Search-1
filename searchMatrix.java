//Time O(log(mn) Binary search on 2D realised as 1D
//Space O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        int mid,midElement;
        while (left <= right) {
            mid = left+(right-left) / 2;
            midElement = matrix[mid / n][mid % n];
            if (target == midElement)
                return true;
            else {
                if (target < midElement)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return false;
    }
}
