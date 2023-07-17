public class SearchIn2DMatrix {
    //Time complexity: O(MXN) row * column
    //Space Complexity: Constant
    public boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length - 1;
        int c = 0;

        while(r >=0 && r < matrix.length && c >=0 && c < matrix[0].length && matrix[r][c] != Integer.MIN_VALUE){
            if(matrix[r][c] == target){
                return true;
            }
            int current = matrix[r][c];
            matrix[r][c] = Integer.MIN_VALUE;

            if(current < target){
                c++;
            }
            if(current > target){
                r--;
            }
        }

        return false;

    }
}
