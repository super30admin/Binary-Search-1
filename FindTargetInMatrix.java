//approach - visualize the matrix as the flattened 1d array and then apply the binary search!
//TC - O(log n)
//Space - O(1)

class FindTargetInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //base case
        if(matrix.length == 0 || matrix == null) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int low = 0;
        int high = row*col - 1;

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int m = mid / col; //row index
            int n = mid % col; //col index
            
            if(matrix[m][n] == target) return true;
            
            if(matrix[m][n] < target) //target lies on right side
            {
                low = mid+1;
            }
            else //target lies on left side
            {
                high = mid -1;
            }
        }
        return false;
    }
}