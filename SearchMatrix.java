class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Since it is sorted considering as 1 D array
        // m = matrix.length;
        // n = matrix[0].length

        // apply binary search , l = 0 , r = m x n - 1
        // find mid , convert it into index of r & col , r = mid / n & c = mid % n
        // check no. at matrix[r][c] if == target return true
        // else if > target , r = mid - 1 else mid +1

        // Time complexit : log m x n -1

        int m = matrix.length; // no. of rows
        int n = matrix[0].length; // no. of columns

        int l = 0;
        int r = m * n - 1;

        int mid = 0;

        while( l <= r ){

            mid = l + (r-l)/2;
            int row = mid / n;
            int col = mid % n;

            if( matrix[row][col] == target ){
                return true;
            }
            else if( matrix[row][col] > target ){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }

        }

        return false;

    }
}