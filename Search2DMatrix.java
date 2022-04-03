/**
 * Time complexity is O(log m*n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                          {10,11,16,20},
                          {23,30,34,60}};
        boolean isPresent = searchMatrix(matrix,70);
        System.out.println(isPresent);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        /*Base case*/
        if(matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length; //number of rows
        int n = matrix[0].length; //number of columns

        int low = 0;
        int high = m*n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
                return true;
            else if(target < matrix[row][col])
                high = mid - 1;
             else
                 low = mid + 1;
        }
        return false;
    }
}
