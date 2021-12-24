/**
 * Time Complexity : O(log(M * N)) where M is row and N is col length of the 2D matrix 
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */

public class SearchInSortedMatrix{
    public static void main(String args[]){
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        SearchIn2DSortedMatrix s = new SearchIn2DSortedMatrix();
        System.out.println(s.searchMatrix(matrix, target));

    }
}

class SearchIn2DSortedMatrix{

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row. 
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1;
        
        while(r < row && c >= 0){
            int curr = matrix[r][c];
            if(curr == target){
                return true;
            }else if(curr > target){
                c--;
            }else{
                r++;
            }
        }
        
        return false;
    }
}