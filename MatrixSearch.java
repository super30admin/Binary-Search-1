
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// assume 2d matrix as single matrix and perform binry search on it.



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    
        int n =  matrix[0].length;
        int m =  matrix.length;
        if(m==1 && n==1){
            if(matrix[m-1][n-1] ==target) return true;
            else return false;
        }
        int high = m*n-1;
        int low =0;
        int mid =0;
        while(low < high){
            mid = low + (high-low)/2;
            if(matrix[mid/n][mid%n] == target) return true;
            else if(matrix[mid/n][mid%n] < target) low = mid+1;
            else high = mid;
        }
        if(matrix[low/n][low%n] == target) return true;
        return false;
        
    }
}