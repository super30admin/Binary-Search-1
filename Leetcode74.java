class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int r = matrix.length;
        int c = matrix[0].length;
        int l = 0;
        int h = r * c - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int row = mid / c;
            int col = mid % c;
            if (matrix[row][col] == target) {
                return true;
            } else if (target > matrix[row][col]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return false;
    }
}

// time complexity: O(log r*c)
// space : O(1)
// logic to find row and column in any 2d array:
// row=index/number of cols
// col=index%number of cols