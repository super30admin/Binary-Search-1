//Time Complexity:O(log n)
//Space Complexity: o(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;//Row length
        int n = matrix[0].length-1; //Column length
        int row = 0, col = n;
        while(row<=m && col >= 0){
            if(matrix[row][col]==target) return true;
            else if(target < matrix[row][col]) 
                col--;
            else
                row++;
        }
        return false;
    }
}