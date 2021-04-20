//Time Complexity: O(log(mn))
//Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m =matrix.length,n=matrix[0].length;
        int left=0, right=m*n-1;
        while(left<=right){
            int mid =left + (right-left)/2;
            int r = mid/n;
            int c =mid%n;
            if(matrix[r][c]==target) return true;
            else if (matrix[r][c]>target) right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}