// Time Complexity :(log (m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
//Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

public class Q1BinarySearch {
    //  time complexity = O(m*n)
    // boolean ans = false;
    // for(int i = 0; i < matrix.length; i++){
    //     for(int j =0; j < matrix[i].length;j++){
    //         if(matrix[i][j]==target)
    //         ans = true;
    //     }
    // }
    // return ans;
    //  time complexity = O(m+n)
    // int i = 0;
    // int j = matrix[0].length-1;
    // while(i < matrix.length && j >= 0){
    //     if(matrix[i][j] == target)
    //         return true;
    //     if(target > matrix[i][j])
    //         i++;
    //     else if(target < matrix[i][j])
    //         j--;
    //     else
    //         break;
    // }
    // return false;
    //  time complexity = O(log(m * n))
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length ;
        int high = m*n - 1;
            while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col]==target)
                return true;
            else if (matrix[row][col] > target){
                high = mid - 1;
            }else
                low = mid + 1;
        }
            return false;
    }
}
