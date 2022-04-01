public class Matrix2D {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null ) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int leftIndex = 0;
        int rightIndex = rows * columns - 1;

        while(leftIndex <= rightIndex){

            // find out the midpoint index
            int midpoint = leftIndex + (rightIndex - leftIndex) / 2;

            // find out the element at the midpoint index and use it for the comparisons
            // finding out the row number - similar to grouping the elements by the number of columns
            // finding out the column number - once the elements are grouped, find out the position in that row
            int valueAtMidpoint = matrix[midpoint/columns][midpoint%columns];
            if(target == valueAtMidpoint){
                return true;
            }else if(target < valueAtMidpoint){
                rightIndex = midpoint - 1;
            } else {
                leftIndex = midpoint + 1;
            }
        }

        return false;
    }
}
