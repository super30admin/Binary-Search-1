class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = rowSearch(matrix,target);
        
        if (row == -1)
        {
            return false;
        }
        
        boolean isFound = binarySearch(matrix, row, target);
        
        return isFound;
    }
    
    public static int rowSearch(int [][] matrix, int target)
    {
        int low = 0;
        int high = matrix.length - 1;
        int lastColoumn = matrix[0].length - 1;
        
        while( low <= high)
        {
           int mid = low + (high - low)/2;
            
            if(target >= matrix[mid][0]   && target <= matrix[mid][lastColoumn])
            {
                return mid;
            }
            else if (target > matrix[mid][0])
            {
                low = mid + 1;
            }
            else if (target < matrix[mid][0])
            {
                high = mid - 1;
            }
        }
    return -1;
    }
    public static boolean binarySearch(int [][] matrix, int r, int target)
    {
        int low = 0;
        int high = matrix[0].length - 1;
        
        while (low <=high)
        {
            int mid = low + (high - low)/2;
            
            if(matrix[r][mid] == target)
            {
                return true;
            }
            else if (matrix[r][mid] < target)
            {
                low = mid + 1;
            }
            
            else if(matrix[r][mid] > target)
            {
                high = mid - 1;
            }
                
        }
        return false;
    }
    
}