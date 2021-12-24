
// Time Complexity : Add : O(log (mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // If matrix length is null, return false
        if(matrix.length == 0)
            return false;

        int rows_len = matrix.length;
        int columns_len = matrix[0].length;

        int left = 0;
        //Last element in the matrix
        int right = rows_len*columns_len -1;

        while(left<=right){
            int midpoint = left + (right-left)/2;
            //Finding midpoint element in matrix. midpoint/columns_len calculates row. midpoint%columns_len calculates column
            int midpoint_element = matrix[midpoint/columns_len][midpoint%columns_len];
            if(target == midpoint_element)
                return true;
            else if (target<midpoint_element)
                right = midpoint-1;
            else
                left = midpoint + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

}
