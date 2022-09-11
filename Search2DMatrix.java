/*Algorithm:
* As the matrix sorted we can think of searching elements with efficient manner using binary search with log n
* Finding element is bit tricky as it is a 2*2 matrix so we need to find the row and column index to locate the element
*   mid = low + (high-low)/2
*   rowIndex = mid / cols
*   colIndex = mid % cols
* 
* Check if target is located at left half --> high = mid-1
*    or if in the right half --> low = mid + 1
* 
* Time Complexity = O(log(mn))
* Space Complexity = O(1)
*/
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        if((rows * cols) <= 0 )
        {
            return false;  //Empty Matrix
        }
        
        // Run Binary Search to find the target
        int low = 0;
        int high = (rows * cols) - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int rowIndex = mid / cols;
            int colIndex = mid % cols;
            
            if(target == matrix[rowIndex][colIndex])
            {
                return true;
            }
            
            if(target < matrix[rowIndex][colIndex])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return false;
    }
}