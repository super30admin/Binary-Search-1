/**

    at each row check if the value lies between start and end of the row
    if we find that row, 
        that means the may or may not be present in that row
        trigger binarySearch on that array
    else return false
    
 Collabedit: http://collabedit.com/aqukn


**/

class Solution {


    public boolean searchMatrix(int[][] matrix, int target) {
    
        int rowSize matrix[0].length;
        int rowCount = matrix.length;
        
        boolean rangePresent = Boolean.FALSE;
        
        for( int i = i< rowCount; i++ ) {
        
            int lowValue = matrix[i][0];
            int highValue = matrix[i][rowSize -1];
            
            if( target >= lowValue && target <= highValue) {
            
                rangePresent = Boolean.TRUE;
                break;
            
            }
        
        }
        
        
        if( rangePresent ) {
        
            boolean isPresent = 
        }
        
    }
    
    boolean binarySearch(int matrix[], int start, int end) {
    
    
    }
}