class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0&&matrix==null) return false;
        int low=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int high=m*n-1;
        while(low<=high){
            int mid = high-low/2;
            int r=mid/n;
            int c=mid%n;
            if(matrix[r][c]==target){
                return true;
            }
            if(matrix[r][c]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}
