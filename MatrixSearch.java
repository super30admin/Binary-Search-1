//time complexity is O(logN)
//space complexity is O(1)
//able to submit the code in leetcode
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = (m*n)-1;
        while(l<=r){
            int pivotidx = (r+l)/2;
            int pivotelm = matrix[pivotidx/n][pivotidx%n];
            if(pivotelm == target){
                return true;
            }
            else if(pivotelm<target){
                l =pivotidx+1;
            }
            else{
                r = pivotidx-1;
            }
        }
        return false;
    }
    public boolean helper(int[] arr, int target){
        int l=0;
        int r = arr.length-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(arr[m]==target){
                return true;
            }
            else if(arr[m]<target){
                l=m+1;
            }
            else
            {
                r=m-1;
            }
        }
        return false;
    }
}
