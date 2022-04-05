//Time Complexity O(logn)
//Space Complexity O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a = matrix[0].length;

        for (int[] prev : matrix) {
            if (prev[prev.length - 1] >= target) {
                for (int j = 0; j <= prev.length; j++) {
                    if (prev[j] == target) {
                        return true;
                    } else if (prev[j] > target) {
                        return false;
                    }
                }

            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int min = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = m * n - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int raw = mid / n;
            int col = mid % n;

            if (matrix[raw][col] == target) {
                return true;
            } else if (matrix[raw][col] < target) {
                min = mid + 1;
            } else if (matrix[raw][col] > target) {
                max = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        Solution solution = new Solution();
        boolean abc = solution.searchMatrix1(matrix, 3);
        System.out.println("Value find in matrix " + abc);
    }
}
