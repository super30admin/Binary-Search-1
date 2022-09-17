// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        //if the matrix is null, return false
        if(matrix == null || matrix.length ==0){
            return false;
        }
        int m=matrix.length; 
        int n=matrix[0].length;
        //binary search by using 0 as low and the last element as high
        int low=0;
        int high = (n*m)-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            //instead of (high+low)/2 as it causes inteager overflow
            //find index
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target){
                return true;
            }
            else if(target> matrix[row][col]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
}