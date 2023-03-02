//Time Complexity : o(n+m)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix.length;
        int row = matrix[0].length;
        int i = 0;
        int j=0;
        while(i<col && j<row){
            if(matrix[i][j]==target){
                return true;
            }
            if(target<=matrix[i][row-1]){
                j++;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
