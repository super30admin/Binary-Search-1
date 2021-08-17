public class SearchIn2DMatrix {

        public boolean searchMatrix(int[][] matrix, int target) {
    
            int m = matrix.length;
            int n = matrix[0].length;
    
            if(matrix==null || matrix.length==0)
                return false;
    
            int low = 0;
            int high = m*n-1;
    
            while(low <=high)
            {
                int mid = low+(high-low)/2;
    
                int row = mid/n;  // imagine we have 1D array, then to get the rows we divide by columns to get the rows.
    
                int col = mid%n;
                // now we got the column we have got the row, we would like to limit the column to the o to len of rows thus we take % operator.
    
                if(matrix[row][col]==target)
                {
                    return true;
                }
                else if(matrix[row][col]>target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
    
            }
    
    
            return false;
        }
    
    
}
