//time complexity = O(logmn)
//space : O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int cols = matrix[0].length;
        int rows= matrix.length;
        
        int high = cols*rows-1;
        int low = 0;
        
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            int rowindex = mid / cols;
            int colindex = mid % cols;
            
            if(target== matrix[rowindex][colindex])
            {
                return true;
            }
            if(matrix[rowindex][colindex] > target)
            {
                high=mid-1;
            }
            
            else
            {
                low=mid+1;
            }
        }
        
        return false;
        
    }
}