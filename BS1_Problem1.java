// Time Complexity : O(Log N * M) // N rows and M Cols
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Creating a imaginary 1d array - with length N*M

Creating low = 0 and high = N*M - 1

Finding Mid element usng low and high

Checking the element at [mid/m][mid%m] is target or not ? 
If it is, return true;
If that element is less or greater than target -- Set low and high accordingly
*/

class twoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        
        int h = matrix.length * matrix[0].length - 1;
        
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(matrix[mid / matrix[0].length][mid % matrix[0].length] == target){
                return true;
            }
            else if(matrix[mid / matrix[0].length][mid % matrix[0].length] < target){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        return false;
    }
}






public class BS1_Problem1{
    public static void main(String[] args){
        twoDMatrix M = new twoDMatrix();
        int[][] matrix = { {1,3,5,7 },{ 10,11,16,20 },{ 23,30,34,60 } };
        int target = 3;
        System.out.println("Is target " + target + " in the Matrix ? " + M.searchMatrix(matrix, target));
    }
}




//Another solution

// Time Complexity : O(N)
/*
    As in the matrix are stored from left to right in row and top to bottom in column as increasing order

    Set i = 0 and j = N - 1 initially
    Starting from last element in the first row : M[0][n-1] 
    Check if it is target or not : If it is return true
    If target is less than element at that index [0][N-1] ==> decrease j by 1 as elements stored in increasing order from left to right
    Otherwise increase i by 1 as elements are stored in increasing order from top to bottom.


    Return false at last //If target not found

*/
/*
class Matrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0; int j = matrix[0].length - 1;
        
        while(i>= 0 && i < matrix.length && j >= 0 && j < matrix[0].length){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        
        
        return false;
    }
}
*/

