class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            }
            else if(target< matrix[r][c]){
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }
        return false;
    }
}