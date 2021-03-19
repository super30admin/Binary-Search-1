class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null && matrix.length == 0){
            return false;
        }
        int l = 0; int m = matrix.length; int n = matrix[0].length;
        int h = m*n -1;
        while (l <= h){
            int mid = l+ (h-l)/2;
            int r = mid/n; int c = mid%n;
            if (matrix[r][c] ==target){
                return true;
            } else if (matrix[r][c] > target){
                h = mid-1;
            } else{
                l = mid+1;
            }
        }
        return false;

    }
}
