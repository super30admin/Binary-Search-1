class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                if(Arrays.binarySearch(matrix[i],target)>=0)return true;
                else return false;
            }
        }
        return false;
    }
}
