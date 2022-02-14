1)Search in a 2d matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int first=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int last=(m*n)-1;
       
        while(first<=last){
         
            int mid=(first+last)/2;
            int i=mid/n;
            int j=mid%n;
            
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]<target){
                first=mid+1;   
            }
            else {
                 last=mid-1;
            }
            mid=(first+last)/2;
        }
        return false;
    }
}
