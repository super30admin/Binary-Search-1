class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //  1 3 5 7||10 11 16 20||23 30 34 60
        //binary search on column1
        //if taget
        if(matrix.length == 0)  return false;
        int m = matrix.length;
        int n = matrix.length;
        int low= 0; int high =m*n-1;
        while( low <= high) {
            int mid = low+ ( high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target)  {
                return true;
            }else if(matrix[r][c]< target) 
            low = mid+1;
            else
            high = mid-1;

        }
        return false;

    }
}