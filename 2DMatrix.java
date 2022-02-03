// Time Complexity : O(log(m*n)) where m is the number of columns and n is number of rows in the matrix 
// Space Complexity :  O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int s = 0;
        //consider all the elements in a contiguous array.
        int e = n*m - 1;
        //normal binary search
        while(s <= e){
            int mid = s + (e - s)/2;
            //i and j determines the indexes of the 2D array
            int i = mid/m;
            int j = mid%m;
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return false;
        
    }
}