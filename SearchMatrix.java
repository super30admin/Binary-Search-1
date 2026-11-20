/*

TC: O(log(mn))
SC: O(1)
Approach : visualize the 2D matrix as a 1D array

*/


class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int r = mid/n;
            int c = mid %n;
            if(matrix[r][c]==target){
                return true;
            }
            if(target> matrix[r][c]){
                low =mid +1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}