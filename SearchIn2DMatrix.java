//time Complexity : log(n)
//space Complexity : O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=matrix.length*matrix[0].length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            int n=mid%matrix[0].length;
            int m=mid/matrix[0].length;
            if (target==matrix[m][n]){
                return true;
            }
            else if (target>matrix[m][n]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
        
        
    }
}