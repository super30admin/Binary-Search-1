// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[i].length-1;
        
        while(i<=matrix.length-1 && j>= 0){
            if(matrix[i][j]==target) {
                return true;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                j--;
            }  
            
        }
        
        return false;
    }
}
