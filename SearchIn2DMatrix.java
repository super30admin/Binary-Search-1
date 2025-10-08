/*
Time complexity: O(log(n)
Space Complexity: O(1)

Approach: We a 2 dimentional array with 2 conditions
     1) Rows are sorted
     2) At any give row last column value at previous row is less than the 1st column value of current row
   If we convert the 2D array into a 1D array it looks like a sorted array of length ((m*n)-1) on which we
        can apply binary search

    To find the location this mid in 2 array we can use
       row value  = ((m*n)-1) / (length of column)
       column value = ((m*n)-1) % (length of column)

    Reason: Visualise it in 2D, we will have 1st row values followed 2nd row values etc... until length/(total number of columns)
            So, to find exact row value we have to divide by column value

            In the order of values in these rows will be in the order of columns so modulus of length will give the exact column location



 */
public class SearchIn2DMatrix {
    // Declaring instance variables
    private int low;
    private int high;
    private int mid;
    private int rows;
    private int columns;
    public boolean searchMatrix(int[][] matrix, int target) {
        // Intializing instance variables based on arguments
        low = 0;
        rows = matrix.length;
        columns = matrix[0].length;
        high = rows*columns -1;
        // Initialise the while loop with break condition low<=high to implement binary search
        while(low <= high){
            // Calculating mid
            mid = low + (high-low)/2;
            // Based on mid calculating row and column values
            int row = mid/columns;
            int column = mid % columns;
            // If target is equal to mid value return true
            if(matrix[row][column] == target) return true;

            // Reducing the search by half
            else{
                // If value lies in right half
                if(matrix[row][column] < target){
                    // remove left half
                    low = mid+1;
                }
                else
                {   // remove left half
                    high = mid -1;
                }
            }
        }
        // It the value isn't present in the array return false
        return false;
    }
}
