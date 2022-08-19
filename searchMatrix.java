/*******
## Problem 1: Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

Time Complexity :   O (log n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (74. Search a 2D Matrix)
Any problem you faced while coding this :       No
*******/

class MysearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columns = matrix[0].length - 1;
        int rows = 0;
        
        while ( rows < matrix.length && columns >=0){
            if( matrix[rows][columns] == target){
                return true;
            }
            else if (matrix[rows][columns] > target){
                columns--;
            }
            else{
                rows++;
            }
        }
        return false;
    }

    public static void main(String args[]) 
    { 
        MysearchMatrix obj = new MysearchMatrix();
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 9;
        System.out.println(obj.searchMatrix(matrix, target));
    }
}
