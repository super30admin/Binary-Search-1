
/*Leetcode 74: Search in a 2d matrix*/ 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        if(row==0){
            return false;
        }
        
        int left = 0;
        int right = row*col-1;
        int element;int mid;
        
        while(left<=right){
            mid = (left+right)/2;
            element = matrix[mid/col][mid%col];
            
            if(target == element){
                return true;
            }else{
                if(target<element){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        
        return false;
        
    }
}