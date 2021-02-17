// Time Complexity : O(log(n))
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; //rows
        int cols = matrix[0].length; //cols
        
        int low = 0;
        int high = rows * cols - 1;
        
        while(low <= high){
            int mid = low + (high-low) / 2;
            int i = mid / cols; //finding row by dividing the element with total columns
            int j = mid % cols; //finding col by modulus the element with total columns
            
            //If target element is equal to mat[i][j] return true;
	    if(matrix[i][j] == target){
                return true;
            }
	    //If target < mat[i][j] disregard the left subhalf;
            else if(matrix[i][j] < target){
                low = mid + 1;
            }
	    //If target < mat[i][j] disregard the right subhalf;
            else {
                high = mid-1;
            }
        }
        
        return false;
    }
    
}



// Time Complexity : O(log(n)+log(m))
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



/* class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //return false if there are no columns or no rows
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        //return false if matrix is null
        if(matrix == null){
            return false;
        }
        
        //take row and column values
        int initialRow = 0;
        int finalRow = matrix.length-1;
        
        int initialCol = 0;
        int finalCol = matrix[0].length-1;
        
        int mid;
	//Binary Search on rows
        while(initialRow < finalRow){
            mid = initialRow + (finalRow - initialRow)/2;
            if(matrix[mid][finalCol] < target){
                initialRow = mid + 1;
            }
            else if(matrix[mid][initialCol] > target){
                finalRow = mid - 1;
            }
            else{
                initialRow = mid;
                break;
            }
        }
     
	//Binary Search on cols
        while(initialCol <= finalCol){
            mid = initialCol + (finalCol - initialCol)/2;
            if(matrix[initialRow][mid] < target){
                initialCol = mid + 1;
            }
            else if(matrix[initialRow][mid] > target){
                finalCol = mid - 1;
            }
            else{
                return true;
            } 
        }
        
        return false;  
    }
    
}
*/