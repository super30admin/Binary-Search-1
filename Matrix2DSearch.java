//Time Complexity : O(log mn)
//Space Complexity : O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix== null || matrix.length ==0)
            return false;
        int low=0;
        int high=matrix.length* matrix[0].length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid / matrix[0].length;
            int col=mid % matrix[0].length;
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col] >=target){
                high=mid-1;
            }
            else 
                low=mid+1;
        }
        return false;
    }
}
