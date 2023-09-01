// Time complexity O(log(m*n))
// Space complexity o(1)
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        
        //binary search
        int left = 0;
        int right = m*n-1;
        int mid;
        while(left<=right){
            mid = (left + right)/2;
            int col = mid % n;
            int row = mid / n;
            if(target == matrix[row][col]){
                return true;
            }
            if(target<matrix[row][col]){
                right = mid-1;
            } else {
                left = mid + 1;
            }
            
        }
        return false;
    }
    
}
