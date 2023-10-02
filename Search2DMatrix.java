
//Time complexity O(log n)
//Space complexity 0(1)

// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : NO

//  We can search the target by using binary search.
//  Calculated low and high by multiplying now rows with no of columns to get the high and low starts with 0.
//  Calculated mid-value and calculated row and column position by using the following formula
// row position = mid / no of columns
// column position = mid % no of columns
// If matrix[r][c] value is equivalent to target return true.  Otherwise, if  matrix[r][c] value is greater than target
// move the high pointer to mid-1 by eliminating the right half of the mid or if the target is greater than matrix[r][c]
// then move the low to mid +1 by eliminating the left half.
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 ){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n -1;
        while(low<= high){
            int mid = low + (high -low)/2; //avoid integer overflow
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            }else if (matrix[r][c] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }

}
