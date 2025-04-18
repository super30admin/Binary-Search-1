// Time Complexity:O(m*n);
// Space Complexity:O(1);
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m =matrix.length;
        int n =matrix[0].length;
        int low =0;
        int high =m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int r=mid/n;
            int c=mid%n;
            if(matrix[r][c]==target) return true;
            else if (matrix[r][c]>target){
                high =mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return false;
    }
}