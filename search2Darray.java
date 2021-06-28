class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if(matrix == null|| matrix.length==0)
        {
            return false;
        }
        
        int row = matrix.length;//row length
        int col = matrix[0].length;//coloumn length
        
        int low = 0;
        int high = (row*col)-1;
        int mid =0;
        
        int r =0;
        int c =0;
        
        while(low<=high)
        {
            mid = low + (high-low)/2;
            r = mid/col;
            c = mid%col;
            if(target == matrix[r][c])
            {
                return true;
            }
            else if(target > matrix[r][c])
            {
                low = mid+1;
            }
            else if(target < matrix[r][c])
            {
                high = mid-1;
            }
            
        }
        return false;
        
        
    }
}
//runtime: Since we are using binary search it is O(logn) and O(1) for the rest of the lines and fuctions
//space complexity: since we are not using any additional space it is O(1)
