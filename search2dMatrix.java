class Solution {
    //Time complexity: O(logmn)
    //Space complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0,h=m*n-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(matrix[mid/n][mid%n]==target){
                return true;
            }
            else if(matrix[mid/n][mid%n]>target){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}