// TC= O(log m*n)
// SC= O(1)

class Solution {
    // we r gonna consider this 2d array a 1d array by flattening it and then applying binary search on it
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n= matrix[0].length;
        int s=0;
        int e= m*n-1;

        while(s<=e){
            int mid= (s+e)/2;
            int i=mid/n;   // getting the row number of the mid element
            int j=mid%n;   // getting the column number of the mid element
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]<target){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return false;
    }
}