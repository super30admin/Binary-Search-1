
// Time Complexity : Log(M x N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[][] = { { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 }
        };
        int target_1 = 3;
        boolean result_1 = searchMatrix(a, target_1);
        System.out.println("Target '" + target_1 + "'' found in Matrix a : " + result_1);

        int target_2 = 13;
        boolean result_2 = searchMatrix(a, target_2);
        System.out.println("Target '" + target_2 + " found in Matrix a : " + result_2);
    }
}