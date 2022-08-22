/*
time complexity
O(n logn)
n for searching if the first value of a row is still lesser than target
logn for searching the row value
space complexity
O(1)
*/
class Solution {
    boolean binarysearch(int a[],int low, int high, int t){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]==t){
                return true;
            }
            if(a[mid]>t){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
          if(matrix[i][0]>target){
              return false;
          }
          else{
             if(binarysearch(matrix[i], 0, matrix[i].length-1, target)==true){
                 return true;
             }
          }
        }
        return false;
    }
}