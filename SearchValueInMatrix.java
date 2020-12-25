/**

    at each row check if the value lies between start and end of the row
    if we find that row, 
        that means the may or may not be present in that row
        trigger binarySearch on that array
    else return false
    
 Collabedit: http://collabedit.com/aqukn


**/

class Solution {

    private final boolean NOT_FOUND = Boolean.FALSE;
    private final boolean FOUND = Boolean.TRUE;
    
    public boolean searchMatrix(int[][] matrix, int target) {
    
        int rowSize = matrix[0].length;
        int rowCount = matrix.length;
        
        boolean rangePresent = Boolean.FALSE;
        
        int i;
        for( i = 0; i< rowCount; i++ ) {
        
            int lowValue = matrix[i][0];
            int highValue = matrix[i][rowSize -1];
            
            if( target >= lowValue && target <= highValue) {
            
                rangePresent = Boolean.TRUE;
                break;
            
            }
        
        }
        
        
        if( rangePresent ) {
        
            return binarySearch(matrix[i], 0, rowSize -1, target);
        }
        else
        {
            return NOT_FOUND;
        }
        
    }
    
    boolean binarySearch(int matrix[], int low, int high, int target) {

        while ( low <= high ) {

            int mid = low + ( high - low )/ 2;

            if(matrix[mid] == target)
                return FOUND;
            else if( matrix[mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        
        
        return NOT_FOUND;
    }
}