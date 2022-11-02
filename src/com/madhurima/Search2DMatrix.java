/*
    Time Complexity = O(logN)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : yes
 */


package com.madhurima;

public class Search2DMatrix {

}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        int mid, row, col;


        while(low <= high){

            mid = low + (high - low)/2; //to prevent integer overflow
            row = mid/n;
            col = mid%n;

            if(target == matrix[row][col]){
                return true;
            }

            if(target < matrix[row][col]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        Solution s = new Solution();
        System.out.println(s.searchMatrix(matrix,target));
    }
}



