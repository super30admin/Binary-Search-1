class Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n-1;
        int mid =0;
        while(low<=high)
        {
            mid = low + (high -low)/2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target)
            {
                high = mid -1;

            }
            else
                low = mid+1;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Matrix m = new Matrix();
        int[][] arr = { { 1, 3,5,7}, { 10, 11,16,20 },{23,30,34,50} };
       System.out.println(m.searchMatrix(arr, 27));
    } 
}