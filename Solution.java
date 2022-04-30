/*
## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

Time complexity: O(log(mn)) ->  O(2log(n)) -> O(log(n))
Spacce complexity: O(1) No auxilary space needed to compute if target exists in the matrix
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {        
        int m = matrix.length,  n = matrix[0].length;
        int left = 0, right = (m*n)-1;       
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            int i = mid/n;
            int j = mid%n;
            
            if(target == matrix[i][j])  return true;
            else if(target > matrix[i][j])  left = mid+1;
            else if(target < matrix[i][j])  right = mid-1;
            }
        return false;
    }
}