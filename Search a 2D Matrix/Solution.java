// time complexity = O(logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int l=0;
        int n=matrix[0].length;
        int h=matrix.length *n;
        while(l<h){
            int m=l+(h-l)/2;
            int r= m/n;
            int c= m%n;
            if(matrix[r][c]==target) return true;
            if(matrix[r][c]<target){
                l=m+1;
            } else {
                h=m;
            }                     
        }
        return false;
    }
}
