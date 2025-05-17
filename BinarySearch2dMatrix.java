class Solution {
    //Time Complexity = O(log(m*n))
    //Space Complexity = O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int r_idx = mid/n, c_idx = mid%n;
            if(matrix[r_idx][c_idx]==target){
                return true;
            }
            else if(matrix[r_idx][c_idx]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}