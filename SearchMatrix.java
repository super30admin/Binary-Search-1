// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class SearchMatrix {
    
    private int binarySearchRow(int[][] matrix, int target) {
        
        int low = 0;
        int high = matrix.length-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            
            
            if(target <= matrix[mid][matrix[0].length-1] ) {
                if(mid ==0 || target > matrix[mid-1][matrix[0].length-1])
                    return mid;
                else {
                    high = mid -1;
                }
            }
            else {
                low = mid+1;
            }
            
        }
        return -1;
    }
    
    private boolean binarySearch(int[][] matrix,int row, int target) {
        int low = 0;
        int high = matrix[0].length-1;
        
        
        while(low <= high) {
            
            int mid = low + (high - low)/2;
                    
            if(target == matrix[row][mid])
                return true;
            else if(target > matrix[row][mid] ) {
                low = mid + 1;
            }
            else {
                high = mid-1;
            }
        }
        return false;
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix,target);
        if(row == -1)
            return false;
        else
            return binarySearch(matrix,row,target);        
    }
}