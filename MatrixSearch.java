public class MatrixSearch {
    
        public boolean searchMatrix(int[][] matrix, int target) {
            int low=0;
            int high = (matrix.length*matrix[0].length)-1;
            while(low<=high)
            {
                int mid= low+(high-low)/2;
                int r = mid/matrix[0].length;
                int c = mid%matrix[0].length;
    
                if(matrix[r][c] == target) return true;
                else if(matrix[r][c] > target)
                {
                    high=mid-1;
                }
                else if(matrix[r][c] < target)
                {
                    low=mid+1;
                }
            }
            return false;
            
        }
    
}
