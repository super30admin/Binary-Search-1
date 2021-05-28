


class Solution {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[m - 1].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int x = findMidRow(matrix, target, 0, m - 1);
        if (x == -1) {
            if (matrix[m - 1][n - 1] == target) {
                return true;
            }
            ;
        }
        int z = matrix[x].length;
        return binarySearch(matrix, target, 0, z - 1, x);
    }

    public static int findMidRow(int[][] matrix, int target, int FR, int LR) {
        if (LR >= FR) {
            int mid = FR + (LR - FR) / 2;

            if (target >= matrix[LR][0]) {
                return LR;
            }
            if (mid + 1 <= LR) {
                if (target >= matrix[mid][0] && target < matrix[mid + 1][0]) {
                    return mid;
                }
                if (target >= matrix[mid][0]) {
                    return findMidRow(matrix, target, mid + 1, LR);
                } else {
                    return findMidRow(matrix, target, FR, mid);
                }
            }
        }
        return -1;
    }

    static boolean binarySearch(int[][] matrix, int target, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (matrix[x][mid] == target)
                return true;
            if (matrix[x][mid] > target)
                return binarySearch(matrix, target, l, mid - 1, x);
            return binarySearch(matrix, target, mid + 1, r, x);
        }
        return false;
    }
}

