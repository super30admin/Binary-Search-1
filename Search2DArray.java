//Time Complexity- O(log m*n)
//Space Complexity- O(1)
//Ran successfully on leetcode


class Search2DArray {
 public boolean searchMatrix(int[][] matrix, int target) {
     if(matrix.length==0 || matrix==null) return false;
     
     int m= matrix.length;
     int n= matrix[0].length;
     int low= 0;
     int high= m*n-1;
     
     while(low<= high){
         
       int mid= low+(high-low)/2;
         
         int row= mid/n;
         int column= mid % n;

         if(matrix[row][column]==target){
             return true;
         }
         else if(target<matrix[row][column]){
             high= mid-1;
         }
         else low= mid+1;
     }
     return false;
 }
}