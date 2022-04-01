
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
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
}
