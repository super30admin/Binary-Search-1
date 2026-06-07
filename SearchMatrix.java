public class SearchMatrix {

    /*
        // Time Complexity : O(log n + log m)
        // Space Complexity : O(1)
        To find a target element in a 2-D matrix which has elements sorted in ascending order, we are treating this 2D matrix as 
        an array which will make it possible to find element using binary search. To find the mid element in the matrix between 
        low and high indexes, we get the row index by dividing mid by column legth and column index by modulo operation with column length.
        Then we compare if the value we are looking for is found return true. If its greater than mid element, we move the low pointer to mid + 1 index 
        else we move the high pointer to mid - 1. If we do not find the element, return false.
    */


   public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int r = mid/col;
            int c = mid % col;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    } 
}
