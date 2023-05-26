// Time Complexity : O(log (m*n))
// Space Complexity : O(1), a bit unsure. Logic: As integer variables (m, n, left, right, mid, row, col, target) are independent of size of input matrix.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No -->

// The code implements a binary search algo to search for the target value in the matrix. It initializes the left and right indices based on the size of the matrix and performs binary search iterations by adjusting the mid index and corresponding row and column indices. 

class Problem1 {
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
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem1 s = new Problem1();
        int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(s.searchMatrix(arr, 20));
    }
}