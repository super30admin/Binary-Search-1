/*
Leet Code Problem 74
Search a 2D Matrix
Language Used : Java
Link: https://leetcode.com/problems/search-a-2d-matrix/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
Memory Usage: 38 MB, less than 93.38% of Java online submissions for Search a 2D Matrix.

Logic: Consider this 2D array as a flat array and perform binary search
To get row and col index the mid is divided for row and mod for the column.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = n*m-1;
        //base case
        if(matrix==null||n==0)return false;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            int r=mid/n;
            int c=mid%n;
            if(matrix[r][c]==target)
                return true;
            else if(matrix[r][c]<target)
                low=mid+1;
            else
               high=mid-1; 
        }        
        return false;
    }
}