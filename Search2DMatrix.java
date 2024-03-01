//Time Complexity:O(log(m*n))

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int n = matrix[0].length;
       
       int m = matrix.length;

       int left=0;
       int right=m*n-1;


       while(left<=right){
           int mid = (left+right)/2;
           int midElement = matrix[mid/n][mid%n];
           if(target==midElement){
               return true;
           }else{
               if(target<midElement){
                   right = mid-1;
               }else{
                   left = mid+1;
               }
           }

       }
       return false;


        
    }
}
