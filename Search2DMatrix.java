//Exercise_5 : Search in a 2D Matrix
// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
//Note : As the matrix is completely sorted, consider it as one dimensional array. Implement Binary Search. Once u get the mid. Find row index by dividing the mid by total columns which is (rowIdx = mid/total columns)and column index by % of mid by total columns (colIdx = mid%total columns). Then proceed according to Binary Search



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
       if(matrix.length==0){
           return false;
       } 
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int start = 0;
        int end   = rows*cols-1; //because index starts form 0
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            int rowIdx = mid/cols;//(cols=total columns)
            int colIdx = mid%cols;//(cols=total columns)
            
            if(target==matrix[rowIdx][colIdx]){
                return true;
            }else if(target<matrix[rowIdx][colIdx]){
                end = mid-1;
            }else{
                start = mid+1;
            }
            
            
        }
        
        return false;
    }
}