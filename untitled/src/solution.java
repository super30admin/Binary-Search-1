//time o(logmn)
//space o(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int m=matrix.length, n = matrix[0].length;

        int r=m-1, c=0;
        while(r>=0 && c<n) {
            if(target < matrix[r][c]) {
                r--;
            } else if(target > matrix[r][c]) {
                c++;
            } else {
                return true;
            }
        }
        return false;
    }
}