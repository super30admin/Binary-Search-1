//Time Complexity - O(log(M*N))
//Space Complexity - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int s = 0, e = m*n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            int i = mid/n;
            int j = mid % n;
            if (matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                e =mid-1;
            }else s= mid +1;

        }
        return false;
    }
}