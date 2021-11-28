// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
            
        // int [][]newMat=matrix;
        //  System.out.println(matrix.length); 
        //  System.out.println(matrix[0].length); 

        if (matrix==null || matrix.length==0) return false;
        
        int m= matrix.length;     //Get row and column of this matrix with this;
        int n=matrix[0].length;
        
        int low=0;
        int high=m*n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int r=mid/n;
            int c=mid%n;
            
            if(matrix[r][c]==target){
                return true;
            }else if(target<matrix[r][c]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return false;
    }
}
