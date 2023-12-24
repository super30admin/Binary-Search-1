
class SearchIn2Dmatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int top = 0;
        int bottom = matrix.length - 1;
        int mid = 0;
        int len = matrix[0].length;

        while(top <= bottom) {
            mid = top + (bottom - top)/2;
            if(matrix[mid][0] <= target && matrix[mid][len -1] >= target) {
                break;
            } else if(matrix[mid][len - 1] > target) {
                bottom = mid - 1;
            } else if(matrix[mid][len - 1] <= target) {
                top = mid + 1;
            }
        }

        int left=0;
        int right = matrix[0].length - 1;

        while(left <= right) {
            int midx = left + (right - left)/2;
            if(matrix[mid][midx] == target) return true;
            else if(matrix[mid][midx] > target) {
                right = midx - 1;
            } else {
                left = midx + 1;
            }
        }

        return false;
    }
}