// time complexity = O(n)
// space complexity = O(n^2)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


        if(matrix[0][0]>target) return false;
        int row=0;

        for(int j=1;j<matrix.length;j++){
            if(matrix[j][0]<=target) row=j;
        }
        System.out.println("row: "+row);
        for(int i=0;i<matrix[row].length;i++){
            if(matrix[row][i]==target) return true;
        }
        return false;

    }
}