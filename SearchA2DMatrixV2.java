// Time Complexity - O(logn)
//Space Complexity - O(1)
// Considering the 2D matrix as a 1D array. As the array elements a re sorted, applying Binary search on the elments
//https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix ==null || matrix.length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0,h=(m*n)-1,mid=l+(h-l)/2;
        while(l<=h){
            mid=l+(h-l)/2;
            int r=mid/n;
            int c=mid%n;
            
            if(matrix[r][c]==target)return true;
            if(matrix[r][c]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}
