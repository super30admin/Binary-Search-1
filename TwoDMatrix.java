
//// Time Complexity : O(log(m*n))
//// Space Complexity : O(1)
//// Did this code successfully run on Leetcode :Yes
//// Any problem you faced while coding this :No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix==null ||matrix.length==0)return false;
        int rowSize=matrix.length;
        int columnSize=matrix[0].length;
        int low=0;
        int high=rowSize*columnSize-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/columnSize;
            int column=mid%columnSize;
            if(matrix[row][column]==target) return true;
            else if(matrix[row][column]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
}