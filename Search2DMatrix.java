// ran on leetcode without issues
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0) return false; //no elements as matrix is empty
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        //perform binary search
        int low = 0;
        int high = rows * columns - 1; //-1 cz it starts with 0
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            //get the mid element and compare with target rather than regular binary search where we used arr[mid] for 2d matrix
            int mid_element = matrix[mid/columns][mid%columns];
            
            if (mid_element == target) {
                return true;
            } else if (target < mid_element) {
                high = mid - 1;
            } else if (target > mid_element) {
                low = mid + 1;
            }
        }
        
        return false;
    }
    
}
