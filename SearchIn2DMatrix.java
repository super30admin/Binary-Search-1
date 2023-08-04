class SearchIn2DMatrix{
    // TC : log(m*n)
    // SC : (1)
    //// Did this code successfully run on Leetcode : yes

    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid / n; // We need to find row, there are n colums.
            int c = mid % n;
            if(matrix[r][c]== target) return true;
            else if(matrix[r][c]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}