//time complexity: O(m+n)
// space complexity: O (m+n)  {not sure} 
class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col=m-1;
        int row =0;
        while(row<n && col >=0){
            if(matrix[row][col] == target){
                return true;
            }
             else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}