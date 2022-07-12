// Time Complexity : O(log mn) where m is number of rows and n is number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Problem: https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        if(m == 0){
            return false;
        }

        for(int i=0;i<m;i++){
            if(target < matrix[i][n-1]){
                m = i;
                break;
            }
        }
        System.out.println(m);

        int l = 0;
        int h = n - 1;
        while(l <= h){
            System.out.print("low and high" + l + h);
            int mid = l + (h - l)/2;
            if(matrix[m][mid] == target){
                return true;
            }else if(matrix[m][mid] < target){
                l = mid+1;
            }else{
                h = mid-1;
            }

        }
        return false;
    }

}


